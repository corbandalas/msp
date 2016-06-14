package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BankDetailsListResponse;
import dto.BaseAPIResponse;
import dto.customer.*;
import exception.WrongCurrencyException;
import exception.WrongPropertyException;
import model.Card;
import model.Currency;
import model.Customer;
import model.Property;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import services.OperationService;
import services.WorldPayPaymentService;
import util.CurrencyUtil;

import java.util.List;
import java.util.Optional;

import static configs.ReturnCodes.*;


/**
 * API customer WorldPay Credit card deposit controller
 *
 * @author corbandalas created 24.05.2016.
 * @since 0.3.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/worldpay", description = "WorldPay deposit payment methods")
public class CustomerWorldPayCreditDepositController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    PropertyRepository propertyRepository;

    @Inject
    WorldPayPaymentService worldPayPaymentService;

    @Inject
    OperationService operationService;

    @Inject
    CacheApi cache;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "initHostedWorldPayPayment",
            value = "Initiate WorldPay credit card deposit method",
            notes = "Allows to initiate redirection to WorldPay hosted payment page",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerWorldPayCreditCardResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerWorldPayCreditCardResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = INCORRECT_KYC_CODE, message = INCORRECT_KYC_TEXT),
            @ApiResponse(code = LIMITS_EXCEEDED_CODE, message = LIMITS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerWorldPayCreditCardDeposit", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> initCreditCardDeposit() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerWorldPayCreditCardDeposit request;
        try {
            request = Json.fromJson(jsonNode, CustomerWorldPayCreditCardDeposit.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getAmount() == null
                || StringUtils.isBlank(request.getCurrency())
                || request.getCardTo() == null
                || StringUtils.isBlank(request.getOrderId())
                || StringUtils.isBlank(request.getSuccessURL())
                || StringUtils.isBlank(request.getFailURL())
                || StringUtils.isBlank(request.getCancelURL())
                ) {

            Logger.error("Missing parameters");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getAmount() <= 0) {
            Logger.error("Negative amount format");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final F.Promise<List<Card>> cardsPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(request.getCurrency()));

        final F.Promise<Optional<Property>> limitPropertyPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.kyc." + customer.getKyc().name()));


        final F.Promise<Result> result = cardsPromise.zip(currencyPromise).zip(limitPropertyPromise).flatMap(data -> {

            final Property amountLimitProperty = data._2.orElseThrow(WrongPropertyException::new);

            final Optional<Currency> currency = data._1._2;

            final List<Card> cards = data._1._1;

            if (!currency.isPresent()) {
                Logger.error("Specified currency doesn't exist");
                return F.Promise.pure(createIncorrectCurrencyResponse());
            }

            Config conf = ConfigFactory.load();

            String sessionTimeOut = conf.getString("cache.worldpay.session.timeout");

            request.setPhone(customer.getId());

            if (request.getCardTo() != null) {

                final Optional<Card> cardTo = cards.stream().filter(itm -> itm.getId().equals(request.getCardTo())).findFirst();
                if (!cardTo.isPresent()) {
                    Logger.error("Specified cardTo doesn't belong to customer");
                    return F.Promise.pure(createWrongCardResponse());
                }

                if (customer.getKyc().equals(KYC.NONE)) {
                    Logger.error("Incorrect KYC level");
                    return F.Promise.pure(createWrongKYCResponse());
                }


                return checkDeposit(cardTo.get(), request.getAmount(), currency, Long.parseLong(amountLimitProperty.getValue())).flatMap(
                        checkLimit -> {
                            if (checkLimit) {
                                return worldPayPaymentService.initHostedtWorldPayPayment(request).map(res -> {

                                    //Store orderID to cache with expiration time out
                                    cache.set(res._2, request, Integer.parseInt(sessionTimeOut) * 60);

                                    return ok(Json.toJson(new CustomerWorldPayCreditCardResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res._1, request.getAmount(), res._2)));

                                });
                            } else {
                                return F.Promise.pure(createLimitsExceededResponse());
                            }
                        }

                );

            } else {

                return F.Promise.wrap(propertyRepository.retrieveById("w2.verification.price.amount")).zip(F.Promise.wrap(propertyRepository.retrieveById("w2.verification.price.currency"))).flatMap(res -> F.Promise.wrap(currencyRepository.retrieveById(res._2.orElseThrow(WrongPropertyException::new))).flatMap(currencyRes -> {

                    Long convertedAmount = 0L;

                    try {
                        convertedAmount = CurrencyUtil.convert(Long.parseLong(res._1.get().getValue()), currencyRes, data._1._2);
                    } catch (WrongCurrencyException e) {
                        Logger.error("Error while retrieving data from DB", e);
                    }

                    request.setAmount(request.getAmount() + convertedAmount);


                    return worldPayPaymentService.initHostedtWorldPayPayment(request).map(rez -> {
                                //Store orderID to cache with expiration time out
                                cache.set(rez._2, request, Integer.parseInt(sessionTimeOut) * 60);

                                return ok(Json.toJson(new CustomerWorldPayCreditCardResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, rez._1, request.getAmount(), rez._2)));
                            }

                    );
                }));
            }

        });

        return returnRecover(result);
    }

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "getBankDetails",
            value = "Obtain list of bank details",
            notes = "Method allows to obtain list of bank account details supported by WorldPay gateway",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "GET",
            response = BankDetailsListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BankDetailsListResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "country", value = "Country", required = true, dataType = "String", paramType = "path"),
    })
    public F.Promise<Result> getBankDetails(String country) {

        final F.Promise<Result> result = worldPayPaymentService.getBankDetails(country).map(details ->
                ok(Json.toJson(new BankDetailsListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), details.getBankDetails().getBankDetailsResultV2()))));
        return returnRecover(result);
    }

    private F.Promise<Boolean> checkDeposit(Card card, long amount, Optional<Currency> currency, long limitAmount) {


        F.Promise<Optional<Currency>> limitCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));
        F.Promise<Double> depositSumPromise = operationService.getDepositSumByCard(card);
        F.Promise<Optional<Currency>> cardCurrencyPromise = F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()));

        return depositSumPromise.zip(cardCurrencyPromise).zip(limitCurrencyPromise).map(res -> {

            final Double depositSum = res._1._1;
            final Optional<Currency> limitCurrency = res._2;
            final long convertedDepositAmount = CurrencyUtil.convert(amount, currency, res._1._2);
            final long convertedLimitAmount = CurrencyUtil.convert(limitAmount, limitCurrency, res._1._2);

            return depositSum.longValue() + convertedDepositAmount < convertedLimitAmount;

        });


    }

}