package controllers.callback;

import com.google.inject.Inject;
import controllers.BaseController;
import dto.customer.CustomerWorldPayCreditCardDeposit;
import exception.CustomerNotRegisteredException;
import exception.WrongCardException;
import exception.WrongCurrencyException;
import model.*;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.mvc.Result;
import provider.CardProvider;
import provider.dto.CardLoadResponse;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import repository.PropertyRepository;
import services.OperationService;
import util.SecurityUtil;

import java.util.Date;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Controller holds  Worldpay callback SOAP methods.
 *
 * @author ra created 23.05.2016.
 * @since 0.2.0
 */
public class WorldpayCallbackController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    CardRepository cardRepository;

    @Inject
    CardProvider cardProvider;

    @Inject
    OperationService operationService;

    @Inject
    CacheApi cache;

    @Inject
    private PropertyRepository propertyRepository;

    /**
     * Deposit callback
     *
     * @return
     */
    public F.Promise<Result> deposit() {

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

        if (soapRequest == null) {
            Logger.error("Couldn't parse SOAP body");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final String phone = soapRequest.getElementsByTagName("itemNumber").item(0).getTextContent();

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


        final F.Promise<Result> result = makePayment(phone, amount, currencyCode, true, null).map(res -> ok(String.format(soapResponse, "SUCCESS")));

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

            return makePayment(customerWorldPayCreditCardDeposit.getPhone(), amount, paymentCurrency, false, customerWorldPayCreditCardDeposit.getCardTo()).map(res -> createRedirect(customerWorldPayCreditCardDeposit.getSuccessURL()));

        });


        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return createRedirect(customerWorldPayCreditCardDeposit.getFailURL());
        });

    }


    private F.Promise<F.Tuple<Operation, Transaction>> makePayment(String phone, long amount, String currencyCode, boolean isBankDeposit, Long cardID) {

        final F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(phone));

        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(currencyCode));

        return customerPromise.zip(currencyPromise).flatMap(data -> {

            if (!data._1.isPresent()) {
                Logger.error("Couldn't find customer for specified phone");
                //TODO: need some action here
                return F.Promise.throwing(new CustomerNotRegisteredException());
            }

            final Customer customer = data._1.get();

            if (!data._2.isPresent()) {
                Logger.error("Couldn't find currency for specified code");
                return F.Promise.throwing(new WrongCurrencyException());
            }

            final Currency currency = data._2.get();

            return F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId())).flatMap(cards -> {
                if (customer.getKyc() == KYC.NONE) {
                    //TODO: some external verificaition

                    return cardProvider.issuePrepaidVirtualCard(customer, "new card", amount, currency).flatMap(cardCreationResponse ->
                            F.Promise.wrap(cardRepository.create(new Card(0L, cardCreationResponse.getToken(), customer.getId(),
                                    CardType.VIRTUAL, CardBrand.VISA, true, new Date(), "alias", true, "info", currency.getId(),
                                    "deliveryAddress1", "deliveryAddress2", "deliveryAddress3", "deliveryCountry"))))
                            .flatMap(card -> operationService.createDepositOperation(card, amount, currency, "", "Worldpay deposit"));
                } else {

                    Card defaultCard = null;

                    if (cardID == null) {

                        final Optional<Card> defaultCardOpt = StreamSupport.stream(cards.spliterator(), true).filter(Card::getCardDefault).findFirst();
                        if (!defaultCardOpt.isPresent()) {
                            Logger.error("Couldn't find default card for specified phone");
                            return F.Promise.throwing(new WrongCardException());
                        }

                        defaultCard = defaultCardOpt.get();

                    } else {

                        final Optional<Card> defaultCardOpt = cards.stream().filter(itm -> itm.getId().equals(cardID)).findFirst();

                        if (!defaultCardOpt.isPresent()) {
                            Logger.error("Couldn't find card for specified ID");
                            return F.Promise.throwing(new WrongCardException());
                        }

                        defaultCard = defaultCardOpt.get();
                    }


                    final F.Promise<CardLoadResponse> cardLoadPromise;
                    if (defaultCard.getType().equals(CardType.VIRTUAL)) {

                        if (isBankDeposit) {
                            cardLoadPromise = cardProvider.loadVirtualCardFromBank(defaultCard, amount, currency, "Worldpay deposit");
                        } else {
                            cardLoadPromise = cardProvider.loadVirtualCardFromCard(defaultCard, amount, currency, "Worldpay deposit");
                        }

                    } else {

                        if (isBankDeposit) {
                            cardLoadPromise = cardProvider.loadPlasticCardFromBank(defaultCard, amount, currency, "Worldpay deposit");
                        } else {
                            cardLoadPromise = cardProvider.loadPlasticCardFromCard(defaultCard, amount, currency, "Worldpay deposit");
                        }
                    }

                    final Card finalDefaultCard = defaultCard;

                    return cardLoadPromise.flatMap(cardLoadResponse -> operationService.createDepositOperation(finalDefaultCard,
                            amount, currency, "" + System.currentTimeMillis(), "Worldpay deposit"));
                }
            });
        });
    }


}
