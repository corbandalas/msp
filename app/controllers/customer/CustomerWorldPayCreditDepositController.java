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
import exception.WrongPropertyException;
import model.Card;
import model.Currency;
import model.Customer;
import model.Property;
import model.enums.CardType;
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
            nickname = "initCreditCardDeposit",
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

        final F.Promise<Result> result = cardsPromise.zip(currencyPromise).flatMap(data -> {

            final Optional<Currency> currency = data._2;

            final List<Card> cards = data._1;

            if (!currency.isPresent()) {
                Logger.error("Specified currency doesn't exist");
                return F.Promise.pure(createIncorrectCurrencyResponse());
            }

            Config conf = ConfigFactory.load();

            String sessionTimeOut = conf.getString("cache.worldpay.session.timeout");

            request.setPhone(customer.getId());


            final Optional<Card> cardTo = cards.stream().filter(itm -> itm.getId().equals(request.getCardTo())).findFirst();

            if (!cardTo.isPresent()) {
                Logger.error("Specified cardTo doesn't belong to customer");
                return F.Promise.pure(createWrongCardResponse());
            }

            if (customer.getKyc().equals(KYC.NONE)) {
                Logger.error("Incorrect KYC level");
                return F.Promise.pure(createWrongKYCResponse());
            }


            return checkDeposit(customer, cardTo.get(), request.getAmount(), currency).flatMap(
                    checkLimit -> {
                        if (checkLimit) {
                            return worldPayPaymentService.initDepositHostedtWorldPayPayment(request).map(res -> {

                                //Store orderID to cache with expiration time out
                                cache.set(res._2, request, Integer.parseInt(sessionTimeOut) * 60);

                                return ok(Json.toJson(new CustomerWorldPayCreditCardResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res._1, res._2)));

                            });
                        } else {
                            return F.Promise.pure(createLimitsExceededResponse());
                        }
                    }

            );


        });

        return returnRecover(result);
    }


    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "initCreditCardPurchase",
            value = "Initiate WorldPay credit purchase method",
            notes = "Allows to initiate redirection to WorldPay hosted payment page",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerWorldPayCreditCardPurchaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerWorldPayCreditCardPurchaseResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = INCORRECT_KYC_CODE, message = INCORRECT_KYC_TEXT),
            @ApiResponse(code = LIMITS_EXCEEDED_CODE, message = LIMITS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerWorldPayCreditCardPurchase", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> initCreditCardPurchase() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerWorldPayCreditCardPurchase request;
        try {
            request = Json.fromJson(jsonNode, CustomerWorldPayCreditCardPurchase.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getCardType() == null
                || StringUtils.isBlank(request.getCurrency())
                || StringUtils.isBlank(request.getOrderId())
                || StringUtils.isBlank(request.getSuccessURL())
                || StringUtils.isBlank(request.getFailURL())
                || StringUtils.isBlank(request.getCancelURL())
                || StringUtils.isBlank(request.getCardType())
                ) {

            Logger.error("Missing parameters");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getAmount() <= 0) {
            request.setAmount(0L);
        }


        CardType cardType;

        try {
            cardType = CardType.valueOf(request.getCardType());

        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (customer.getKyc().equals(KYC.NONE)) {
            Logger.error("Incorrect KYC level");
            return F.Promise.pure(createWrongKYCResponse());
        }

        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(request.getCurrency()));
        final F.Promise<Optional<Property>> priceAmountPromise = F.Promise.wrap(propertyRepository.retrieveById("price.msp.card." + cardType.name()));
        final F.Promise<Optional<Currency>> priceCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("price.msp.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));

        final CardType finalCardType = cardType;
        final F.Promise<Result> result = priceAmountPromise.zip(priceCurrencyPromise).zip(currencyPromise).flatMap(data -> {

            long priceAmount = Long.parseLong(data._1._1.get().getValue());

            Optional<Currency> priceCurrency = data._1._2;

            final Optional<Currency> currency = data._2;

            if (!currency.isPresent()) {
                Logger.error("Specified currency doesn't exist");
                return F.Promise.pure(createIncorrectCurrencyResponse());
            }

            Config conf = ConfigFactory.load();

            String sessionTimeOut = conf.getString("cache.worldpay.session.timeout");

            request.setPhone(customer.getId());

            if (customer.getKyc().equals(KYC.NONE)) {
                Logger.error("Incorrect KYC level");
                return F.Promise.pure(createWrongKYCResponse());
            }

            final long totalAmount = CurrencyUtil.convert(priceAmount, priceCurrency, currency) + request.getAmount();

            return checkCardNumberAndDepositSum(customer, finalCardType, request.getAmount(), currency).flatMap(
                    checkLimit -> {
                        if (checkLimit) {
                            return worldPayPaymentService.initPurchaseHostedtWorldPayPayment(request, totalAmount).map(res -> {

                                Logger.info("Put request object to cache with id: " + res._2);

                                //Store orderID to cache with expiration time out
                                cache.set(res._2, request, Integer.parseInt(sessionTimeOut) * 60);

                                return ok(Json.toJson(new CustomerWorldPayCreditCardPurchaseResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res._1, totalAmount, res._2)));

                            });
                        } else {
                            return F.Promise.pure(createLimitsExceededResponse());
                        }
                    }

            );


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

    private F.Promise<Boolean> checkDeposit(Customer customer, Card card, long amount, Optional<Currency> currency) {


        final F.Promise<Optional<Currency>> limitCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));
        final F.Promise<Double> depositSumPromise = operationService.getDepositSumByCard(card);
        final F.Promise<Optional<Currency>> cardCurrencyPromise = F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()));
        final F.Promise<Optional<Property>> limitAmountPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.kyc." + customer.getKyc().name()));


        return depositSumPromise.zip(cardCurrencyPromise).zip(limitCurrencyPromise).zip(limitAmountPromise).map(res -> {

            final Double depositSum = res._1._1._1;
            final Optional<Currency> limitCurrency = res._1._1._2;
            final Optional<Currency> cardCurrency = res._1._2;

            final Property property = res._2.orElseThrow(WrongPropertyException::new);

            final long convertedDepositAmount = CurrencyUtil.convert(amount, currency, cardCurrency);
            final long convertedLimitAmount = CurrencyUtil.convert(Long.parseLong(property.getValue()), limitCurrency, cardCurrency);

            return depositSum.longValue() + convertedDepositAmount < convertedLimitAmount;

        });
    }

    private F.Promise<Boolean> checkDepositToNew(Customer customer, long amount, Optional<Currency> currency) {


        final F.Promise<Optional<Currency>> limitCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));
        final F.Promise<Optional<Property>> limitAmountPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.kyc." + customer.getKyc().name()));


        return limitCurrencyPromise.zip(limitAmountPromise).map(res -> {

            final Optional<Currency> limitCurrency = res._1;

            final Property property = res._2.orElseThrow(WrongPropertyException::new);

            final long convertedDepositAmount = CurrencyUtil.convert(amount, currency, limitCurrency);
            final long convertedLimitAmount = Long.parseLong(property.getValue());

            return convertedDepositAmount < convertedLimitAmount;

        });
    }



    private F.Promise<Boolean> checkCardNumberAndDepositSum(Customer customer, CardType cardType, long amount, Optional<Currency> currency) {
        return checkDepositToNew(customer, amount, currency).zip(checkCardPurchaseNumber(customer, cardType)).map(rez -> rez._1 && rez._2);
    }


    private F.Promise<Boolean> checkCardPurchaseNumber(Customer customer, CardType cardType) {


        final F.Promise<Long> virtualCardNumberPromise = F.Promise.wrap(cardRepository.countCardsByType(customer.getId(), CardType.VIRTUAL));
        final F.Promise<Long> plasticCardNumberPromise = F.Promise.wrap(cardRepository.countCardsByType(customer.getId(), CardType.PLASTIC));

        F.Promise<Optional<Property>> cardLimitNumberPromise = null;

        if (customer.getKyc().equals(KYC.SIMPLIFIED_DUE_DILIGENCE)) {
            cardLimitNumberPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.msp.card.SIMPLIFIED_DUE_DILIGENCE"));
        } else {
            cardLimitNumberPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.msp.card.FULL_DUE_DILIGENCE." + cardType.name()));
        }

        return virtualCardNumberPromise.zip(plasticCardNumberPromise).zip(cardLimitNumberPromise).map(res -> {

            long virtualCardNumber = res._1._1;
            long plasticCardNumber = res._1._2;

            long cardLimit = Long.parseLong(res._2.get().getValue());

            if (customer.getKyc().equals(KYC.SIMPLIFIED_DUE_DILIGENCE)) {
                return virtualCardNumber + 1 <= cardLimit && plasticCardNumber + 1 <= cardLimit;
            } else {
                if (cardType.equals(CardType.VIRTUAL)) {
                    return virtualCardNumber + 1 <= cardLimit;
                } else if (cardType.equals(CardType.PLASTIC)) {
                    return plasticCardNumber + 1 <= cardLimit;
                }
            }

            return false;
        });

    }


}