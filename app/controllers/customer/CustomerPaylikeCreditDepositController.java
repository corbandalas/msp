package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.CustomerPaylikeCreditCardDeposit;
import dto.customer.CustomerPaylikeCreditCardPurchase;
import dto.customer.CustomerPaylikeCreditCardPurchaseResponse;
import dto.customer.CustomerPaylikeCreditCardResponse;
import model.*;
import model.enums.CardType;
import model.enums.FeeDestinationType;
import model.enums.KYC;
import model.enums.OperationType;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.*;
import services.OperationService;
import services.PaylikePaymentService;
import util.FeeUtil;
import util.Utils;

import java.util.List;
import java.util.Optional;

import static configs.ReturnCodes.*;

/**
 * API customer Paylike Credit card deposit controller
 *
 * @author corbandalas created 02.02.2017.
 * @since 0.4.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/paylike", description = "Paylike deposit payment methods")
public class CustomerPaylikeCreditDepositController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CardProvider cardProvider;

    @Inject
    PropertyRepository propertyRepository;

    @Inject
    PaylikePaymentService paylikePaymentService;

    @Inject
    OperationService operationService;

    @Inject
    FeeIntervalRepository feeIntervalRepository;

    @Inject
    FeeRepository feeRepository;

    @Inject
    CacheApi cache;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "initCreditCardDeposit",
            value = "Initiate Paylike credit card deposit method",
            notes = "Allows to initiate redirection to Paylike hosted payment page",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerPaylikeCreditCardResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerPaylikeCreditCardResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = INCORRECT_KYC_CODE, message = INCORRECT_KYC_TEXT),
            @ApiResponse(code = LIMITS_EXCEEDED_CODE, message = LIMITS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerPaylikeCreditCardDeposit", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> initCreditCardDeposit() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerPaylikeCreditCardDeposit request;
        try {
            request = Json.fromJson(jsonNode, CustomerPaylikeCreditCardDeposit.class);
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


            return checkDeposit(customer, cardTo.get(), request.getAmount(), currency, propertyRepository, currencyRepository, operationService).flatMap(
                    checkLimit -> {
                        if (checkLimit) {
                            return paylikePaymentService.getPaymentLinkDeposit(request).map(res -> {

                                //Store orderID to cache with expiration time out
                                cache.set(request.getOrderId(), request, Integer.parseInt(sessionTimeOut) * 60);

                                return ok(Json.toJson(new CustomerPaylikeCreditCardResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res)));

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
            value = "Initiate Paylike credit purchase method",
            notes = "Allows to initiate redirection to Paylike hosted payment page",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerPaylikeCreditCardPurchaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerPaylikeCreditCardPurchaseResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = INCORRECT_KYC_CODE, message = INCORRECT_KYC_TEXT),
            @ApiResponse(code = LIMITS_EXCEEDED_CODE, message = LIMITS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerPaylikeCreditCardPurchase", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> initCreditCardPurchase() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerPaylikeCreditCardPurchase request;
        try {
            request = Json.fromJson(jsonNode, CustomerPaylikeCreditCardPurchase.class);
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

        Integer accountID = (Integer)cache.get("account_" + customer.getId());

        F.Promise<Long> totalSumWithFee = FeeUtil.getTotalSumWithFee(accountID, request.getAmount(), request.getCurrency(), OperationType.valueOf("CARD_PURCHASE_" + request.getCardType()), FeeDestinationType.THIRD_PARTY, feeRepository, feeIntervalRepository);

        final CardType finalCardType = cardType;
        final F.Promise<Result> result = totalSumWithFee.zip(currencyPromise).flatMap(data -> {

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

            final long totalAmount = data._1;

            return checkCardNumberAndDepositSum(customer, finalCardType, request.getAmount(), currency, currencyRepository, cardRepository, propertyRepository).flatMap(
                    checkLimit -> {
                        if (checkLimit) {
                            return paylikePaymentService.getPaymentLinkPurchase(totalAmount, request).map(res -> {


                                //Store orderID to cache with expiration time out
                                cache.set(request.getOrderId(), request, Integer.parseInt(sessionTimeOut) * 60);

                                return ok(Json.toJson(new CustomerPaylikeCreditCardPurchaseResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res, totalAmount)));

                            });
                        } else {
                            return F.Promise.pure(createLimitsExceededResponse());
                        }
                    }

            );


        });

        return returnRecover(result);
    }


    public F.Promise<Result> creditCardDepositCallback() {

        String transactionID = request().getQueryString("transactionId");

        final F.Promise<Optional<Property>> defaultErrorURLPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.api.msp.client.error.redirect.url"));


        final F.Promise<Result> result = defaultErrorURLPromise.flatMap(url -> {

            String defaultErrorURL = url.get().getValue();

            if (StringUtils.isBlank(transactionID)) {
                Logger.error("TransactionID is empty!");
                return F.Promise.pure(createRedirect(defaultErrorURL));
            }


            return paylikePaymentService.fetchPaylikeTransaction(transactionID).flatMap(transaction -> {

                if (!transaction.getTransaction().getCapturedAmount().equals(0)) {
                    Logger.error("Paylike transaction was already captured");
                    return F.Promise.pure(createRedirect(defaultErrorURL));
                }

                if (!transaction.getTransaction().getSuccessful()) {
                    Logger.error("Paylike transaction wasn't successful");
                    return F.Promise.pure(createRedirect(defaultErrorURL));
                }

                String reference = transaction.getTransaction().getCustom().getReference();

                CustomerPaylikeCreditCardDeposit customerPaylikeCreditCardDeposit = cache.get(reference);

                if (customerPaylikeCreditCardDeposit == null) {
                    Logger.error("There is no payment info in cache");
                    return F.Promise.pure(createRedirect(defaultErrorURL));
                } else {
                    cache.remove(reference);
                }


                return paylikePaymentService.capturePaylikeTransaction(transactionID, transaction.getTransaction().getAmount(), transaction.getTransaction().getCurrency()).flatMap(capture -> {

                    if (capture.getTransaction().getCapturedAmount().equals(transaction.getTransaction().getAmount())) {
                        Logger.info("Paylike transaction was captured successfully");

                        return makePayment(customerPaylikeCreditCardDeposit.getPhone(), transaction.getTransaction().getAmount(),
                                transaction.getTransaction().getCurrency(), false,
                                customerPaylikeCreditCardDeposit.getCardTo(), customerRepository, currencyRepository, cardProvider, cardRepository, operationService)
                                .map(res -> createRedirect(customerPaylikeCreditCardDeposit.getSuccessURL()))
                                .recover(
                                        throwable -> {
                                            Logger.error("Error: ", throwable);
                                            paylikePaymentService.refundPaylikeTransaction(transactionID, transaction.getTransaction().getAmount());
                                            return createRedirect(customerPaylikeCreditCardDeposit.getFailURL());
                                        }
                                );
                    } else {
                        Logger.error("Paylike transaction was not captured successfully");
                        return F.Promise.pure(createRedirect(customerPaylikeCreditCardDeposit.getFailURL()));
                    }
                });

            });

        });

        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return createRedirect("");
        });

    }


    public F.Promise<Result> creditCardPurchaseCallback() {

        String transactionID = request().getQueryString("transactionId");

        final F.Promise<Optional<Property>> defaultErrorURLPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.api.msp.client.error.redirect.url"));

        final F.Promise<Result> result = defaultErrorURLPromise.flatMap(url -> {

            String defaultErrorURL = url.get().getValue();

            if (StringUtils.isBlank(transactionID)) {
                Logger.error("TransactionID is empty!");
                return F.Promise.pure(createRedirect(defaultErrorURL));
            }


            return paylikePaymentService.fetchPaylikeTransaction(transactionID).flatMap(transaction -> {

                if (!transaction.getTransaction().getCapturedAmount().equals(0)) {
                    Logger.error("Paylike transaction was already captured");
                    return F.Promise.pure(createRedirect(defaultErrorURL));
                }

                if (!transaction.getTransaction().getSuccessful()) {
                    Logger.error("Paylike transaction wasn't successful");
                    return F.Promise.pure(createRedirect(defaultErrorURL));
                }

                String reference = transaction.getTransaction().getCustom().getReference();

                CustomerPaylikeCreditCardPurchase customerPaylikeCreditCardPurchase = cache.get(reference);

                if (customerPaylikeCreditCardPurchase == null) {
                    Logger.error("There is no payment info in cache");
                    return F.Promise.pure(createRedirect(defaultErrorURL));
                } else {
                    cache.remove(reference);
                }

                long totalPaymentAmount = transaction.getTransaction().getAmount();
                String paymentCurrency = transaction.getTransaction().getCurrency();


//                final F.Promise<Optional<Property>> priceAmountPromise = F.Promise.wrap(propertyRepository.retrieveById("price.msp.card." + customerPaylikeCreditCardPurchase.getCardType()));
//                final F.Promise<Optional<Currency>> priceCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("price.msp.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));
                Integer accountID = (Integer)cache.get("account_" + customerPaylikeCreditCardPurchase.getPhone());

                F.Promise<Long> totalSumWithFee = FeeUtil.getTotalSumWithFee(accountID, customerPaylikeCreditCardPurchase.getAmount(), customerPaylikeCreditCardPurchase.getCurrency(), OperationType.valueOf("CARD_PURCHASE_" + customerPaylikeCreditCardPurchase.getCardType()), FeeDestinationType.THIRD_PARTY, feeRepository, feeIntervalRepository);

                final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(customerPaylikeCreditCardPurchase.getCurrency()));

                return totalSumWithFee.zip(currencyPromise).flatMap(rez -> {

                    final long totalCalculatedAmount = rez._1;

                    Logger.info("totalPaymentAmount = " + totalPaymentAmount);
                    Logger.info("totalCalculatedAmount = " + totalCalculatedAmount);

                    if (totalPaymentAmount != totalCalculatedAmount) {
                        Logger.error("Amounts are different!");
                        return F.Promise.pure(createRedirect(customerPaylikeCreditCardPurchase.getFailURL()));
                    }

                    return paylikePaymentService.capturePaylikeTransaction(transactionID, transaction.getTransaction().getAmount(), transaction.getTransaction().getCurrency()).flatMap(capture -> {

                        if (capture.getTransaction().getCapturedAmount().equals(transaction.getTransaction().getAmount())) {
                            Logger.info("Paylike transaction was captured successfully");

                            return cardPurchase(customerPaylikeCreditCardPurchase.getPhone(), customerPaylikeCreditCardPurchase.getAmount(), paymentCurrency, CardType.valueOf(customerPaylikeCreditCardPurchase.getCardType()), customerRepository, currencyRepository, cardProvider, cardRepository)
                                    .map(res -> createRedirect(customerPaylikeCreditCardPurchase.getSuccessURL() + "?crdtcn=" + res._1.getToken() + "&crdpan=" + Utils.maskCardNumber(res._2.getPan()) + "&crdexp=" + res._2.getExpDate()))
                                    .map(res -> createRedirect(customerPaylikeCreditCardPurchase.getSuccessURL()))
                                    .recover(
                                            throwable -> {
                                                Logger.error("Error: ", throwable);
                                                paylikePaymentService.refundPaylikeTransaction(transactionID, transaction.getTransaction().getAmount());
                                                return createRedirect(customerPaylikeCreditCardPurchase.getFailURL());
                                            }
                                    );
                        } else {
                            Logger.error("Paylike transaction was not captured successfully");
                            return F.Promise.pure(createRedirect(customerPaylikeCreditCardPurchase.getFailURL()));
                        }
                    });


                });


            });

        });

        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return createRedirect("");
        });

    }

}