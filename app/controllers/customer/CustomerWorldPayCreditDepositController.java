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
import exception.*;
import model.*;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import provider.dto.CardCreationResponse;
import provider.dto.CardLoadResponse;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import repository.PropertyRepository;
import services.OperationService;
import services.WorldPayPaymentService;
import util.CurrencyUtil;
import util.SecurityUtil;
import util.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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
    CardProvider cardProvider;

    @Inject
    CacheApi cache;

    @Inject
    CustomerRepository customerRepository;

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


            return checkDeposit(customer, cardTo.get(), request.getAmount(), currency, propertyRepository, currencyRepository, operationService).flatMap(
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
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")
    })
    public F.Promise<Result> getBankDetails(String country) {

        final F.Promise<Result> result = worldPayPaymentService.getBankDetails(country).map(details ->
                ok(Json.toJson(new BankDetailsListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), details.getBankDetails().getBankDetailsResultV2()))));
        return returnRecover(result);
    }


    private F.Promise<Boolean> checkCardNumberAndDepositSum(Customer customer, CardType cardType, long amount, Optional<Currency> currency) {
        return checkDepositToNew(customer, amount, currency, currencyRepository, propertyRepository).zip(checkCardPurchaseNumber(customer, cardType, cardRepository, propertyRepository)).map(rez -> rez._1 && rez._2);
    }


    /**
     * Deposit callback
     *
     * @return
     */
    public F.Promise<Result> bankDeposit() {

        final String soapResponse = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" +
                " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"" +
                " xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soap:Body>" +
                "<PaymentNotificationResponse xmlns=\"http://apilistener.envoyservices.com\">" +
                "<PaymentNotificationResult>%s</PaymentNotificationResult>" +
                "</PaymentNotificationResponse>" +
                "</soap:Body>" +
                "</soap:Envelope>";

        final Document soapRequest = request().body().asXml();

        Logger.info("Soap request xml: \n{}", request().body().toString());

        if (soapRequest == null) {
            Logger.error("Couldn't parse SOAP body");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final String phone = soapRequest.getElementsByTagName("bankInformation").item(0).getTextContent();

        final String currencyCode = soapRequest.getElementsByTagName("appliedCurrency").item(0).getTextContent();
        if (currencyCode == null) {
            Logger.error("Couldn't find currency code in SOAP request");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final String appliedAmount = soapRequest.getElementsByTagName("appliedAmount").item(0).getTextContent();
        if (appliedAmount == null) {
            Logger.error("Couldn't find amount in SOAP request");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final Long amount = (long) (Double.parseDouble(appliedAmount) * 100);


        final F.Promise<Result> result = makePayment(phone, amount, currencyCode, true, null, customerRepository, currencyRepository, cardProvider, cardRepository, operationService)
                .map(res -> ok(String.format(soapResponse, "SUCCESS")));

        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return ok(String.format(soapResponse, "ERROR"));
        });
    }

    /**
     * WorldPay Credit Card Deposit callback
     *
     * @return
     */
    public F.Promise<Result> creditCardDeposit() {

        String mspOrderKey = request().getQueryString("ordk");

        if (StringUtils.isBlank(mspOrderKey)) {
            Logger.error("Internal order ID is empty!");
            return F.Promise.pure(createRedirect("https://google.com"));
        }

        CustomerWorldPayCreditCardDeposit customerWorldPayCreditCardDeposit = cache.get(mspOrderKey);

        cache.remove(mspOrderKey);

        if (customerWorldPayCreditCardDeposit == null) {
            return F.Promise.pure(createRedirect("https://google.com"));
        }

        String paymentStatus = request().getQueryString("paymentStatus");

        if (StringUtils.isBlank(paymentStatus)) {
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardDeposit.getCancelURL()));
        } else if (!StringUtils.equalsIgnoreCase(paymentStatus, "AUTHORISED")) {
            Logger.error("Payment transaction is not authorised by WorldPay");
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardDeposit.getFailURL()));
        }


        String orderKey = request().getQueryString("orderKey");
        String paymentAmount = request().getQueryString("paymentAmount");
        String paymentCurrency = request().getQueryString("paymentCurrency");
        String mac = request().getQueryString("mac");

        if (StringUtils.isBlank(orderKey)
                || StringUtils.isBlank(paymentAmount)
                || StringUtils.isBlank(paymentCurrency)
                || StringUtils.isBlank(mac)) {

            Logger.error("Missing request parameters");
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardDeposit.getFailURL()));
        }

        long amount = Long.parseLong(paymentAmount);

        if (amount != customerWorldPayCreditCardDeposit.getAmount()) {
            Logger.error("Amounts are different!");
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardDeposit.getFailURL()));
        }

        if (!paymentCurrency.equalsIgnoreCase(customerWorldPayCreditCardDeposit.getCurrency())) {
            Logger.error("Currencies are different!");
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardDeposit.getFailURL()));
        }

        F.Promise<Result> result = F.Promise.wrap(propertyRepository.retrieveById("worldpay.hosted.payment.secret")).flatMap(rez -> {

            String secret = rez.get().getValue();

            String generatedMAC = SecurityUtil.generateKeyFromArrayMD5(orderKey, paymentAmount, paymentCurrency, paymentStatus, secret);

            if (!StringUtils.equalsIgnoreCase(generatedMAC, mac)) {
                Logger.error("MAC is not correct!");
                return F.Promise.pure(createRedirect(customerWorldPayCreditCardDeposit.getFailURL()));
            }

            return makePayment(customerWorldPayCreditCardDeposit.getPhone(), amount, paymentCurrency, false, customerWorldPayCreditCardDeposit.getCardTo(), customerRepository, currencyRepository, cardProvider, cardRepository, operationService)
                    .map(res -> createRedirect(customerWorldPayCreditCardDeposit.getSuccessURL()));

        });


        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return createRedirect(customerWorldPayCreditCardDeposit.getFailURL());
        });

    }


    /**
     * WorldPay Credit Card Deposit callback
     *
     * @return
     */
    public F.Promise<Result> creditCardPurchase() {

        String mspOrderKey = request().getQueryString("ordk");

        Logger.info("Order id: " + mspOrderKey);

        if (StringUtils.isBlank(mspOrderKey)) {
            Logger.error("Internal order ID is empty!");
            return F.Promise.pure(createRedirect("https://google.com"));
        }

        CustomerWorldPayCreditCardPurchase customerWorldPayCreditCardPurchase = cache.get(mspOrderKey);

        cache.remove(mspOrderKey);

        if (customerWorldPayCreditCardPurchase == null) {
            Logger.error("Cached order object is null");
            return F.Promise.pure(createRedirect("https://google.com"));
        }

        String paymentStatus = request().getQueryString("paymentStatus");

        if (StringUtils.isBlank(paymentStatus)) {
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardPurchase.getCancelURL()));
        } else if (!StringUtils.equalsIgnoreCase(paymentStatus, "AUTHORISED")) {
            Logger.error("Payment transaction is not authorised by WorldPay");
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardPurchase.getFailURL()));
        }


        String orderKey = request().getQueryString("orderKey");
        String paymentAmount = request().getQueryString("paymentAmount");
        String paymentCurrency = request().getQueryString("paymentCurrency");
        String mac = request().getQueryString("mac");

        if (StringUtils.isBlank(orderKey)
                || StringUtils.isBlank(paymentAmount)
                || StringUtils.isBlank(paymentCurrency)
                || StringUtils.isBlank(mac)) {

            Logger.error("Missing request parameters");
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardPurchase.getFailURL()));
        }

        long totalPaymentAmount = Long.parseLong(paymentAmount);


        if (!paymentCurrency.equalsIgnoreCase(customerWorldPayCreditCardPurchase.getCurrency())) {
            Logger.error("Currencies are different!");
            return F.Promise.pure(createRedirect(customerWorldPayCreditCardPurchase.getFailURL()));
        }

        final F.Promise<Optional<Property>> priceAmountPromise = F.Promise.wrap(propertyRepository.retrieveById("price.msp.card." + customerWorldPayCreditCardPurchase.getCardType()));
        final F.Promise<Optional<Currency>> priceCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("price.msp.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));
        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(customerWorldPayCreditCardPurchase.getCurrency()));

        F.Promise<Result> result = F.Promise.wrap(propertyRepository.retrieveById("worldpay.hosted.payment.secret")).zip(priceAmountPromise).zip(priceCurrencyPromise).zip(currencyPromise).flatMap(rez -> {

            final Optional<Currency> requestCurrency = rez._2;

            final Optional<Currency> priceCurrency = rez._1._2;

            final long priceAmount = Long.parseLong(rez._1._1._2.get().getValue());

            final long totalCalculatedAmount = CurrencyUtil.convert(priceAmount, priceCurrency, requestCurrency) + customerWorldPayCreditCardPurchase.getAmount();

            if (totalPaymentAmount != totalCalculatedAmount) {
                Logger.error("Amounts are different!");
                return F.Promise.pure(createRedirect(customerWorldPayCreditCardPurchase.getFailURL()));
            }

            String secret = rez._1._1._1.get().getValue();

            String generatedMAC = SecurityUtil.generateKeyFromArrayMD5(orderKey, paymentAmount, paymentCurrency, paymentStatus, secret);

            if (!StringUtils.equalsIgnoreCase(generatedMAC, mac)) {
                Logger.error("MAC is not correct!");
                return F.Promise.pure(createRedirect(customerWorldPayCreditCardPurchase.getFailURL()));
            }

            return cardPurchase(customerWorldPayCreditCardPurchase.getPhone(), customerWorldPayCreditCardPurchase.getAmount(), paymentCurrency, CardType.valueOf(customerWorldPayCreditCardPurchase.getCardType()),
                    customerRepository, currencyRepository, cardProvider, cardRepository)
                    .map(res -> createRedirect(customerWorldPayCreditCardPurchase.getSuccessURL() + "?crdtcn=" + res._1.getToken() + "&crdpan=" + Utils.maskCardNumber(res._2.getPan()) + "&crdexp=" + res._2.getExpDate()));

        });


        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return createRedirect(customerWorldPayCreditCardPurchase.getFailURL());
        });

    }


}