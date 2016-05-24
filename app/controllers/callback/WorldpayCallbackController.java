package controllers.callback;

import com.google.inject.Inject;
import controllers.BaseController;
import model.Card;
import model.Currency;
import model.Customer;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import play.Logger;
import play.libs.F;
import play.libs.XPath;
import play.mvc.Result;
import provider.CardProvider;
import provider.dto.CardLoadResponse;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import services.OperationService;

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

    /**
     * Deposit callback
     *
     * @return
     */
    public F.Promise<Result> deposit() {

        final String soapResponse = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                " <soap:Body>\n" +
                " <PaymentNotificationResponse xmlns=\"http://apilistener.envoyservices.com\">\n" +
                " <PaymentNotificationResult>%s</PaymentNotificationResult>\n" +
                " </PaymentNotificationResponse>\n" +
                " </soap:Body>\n" +
                "</soap:Envelope>";

        final Document soapRequest = request().body().asXml();
        if (soapRequest == null) {
            Logger.error("Couldn't parse SOAP body");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final Node paymentRequest = XPath.selectNode("//paymentNotification/payment", soapRequest);
        if (paymentRequest == null) {
            Logger.error("Couldn't find payment object in SOAP body");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final String phone = XPath.selectText("//itemNumber", paymentRequest);

        final F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(phone));

        final String currencyCode = XPath.selectText("//appliedCurrency", paymentRequest);
        if (currencyCode == null) {
            Logger.error("Couldn't find currency code in SOAP request");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(currencyCode));

        final String appliedAmount = XPath.selectText("//appliedAmount", paymentRequest);
        if (appliedAmount == null) {
            Logger.error("Couldn't find amount in SOAP request");
            return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
        }

        final Long amount = Long.parseLong(appliedAmount);

        final F.Promise<Result> result = customerPromise.zip(currencyPromise).flatMap(data -> {

            if (!data._1.isPresent()) {
                Logger.error("Couldn't find customer for specified phone");
                //TODO: need some action here
                return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
            }

            final Customer customer = data._1.get();

            if (!data._2.isPresent()) {
                Logger.error("Couldn't find currency for specified code");
                return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
            }

            final Currency currency = data._2.get();

            return F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId())).flatMap(cards -> {
                if (customer.getKyc() == KYC.NONE) {
                    //TODO: some external verificaition

                    return cardProvider.issuePrepaidVirtualCard(customer, "new card", amount, currency).flatMap(cardCreationResponse ->
                            F.Promise.wrap(cardRepository.create(new Card(0L, cardCreationResponse.getToken(), customer.getId(),
                                    CardType.VIRTUAL, CardBrand.VISA, true, new Date(), "alias", true, "info", currency.getId(),
                                    "deliveryAddress1", "deliveryAddress2", "deliveryAddress3", "deliveryCountry"))))
                            .flatMap(card -> operationService.createDepositOperation(card, amount, currency, "", "Worldpay deposit"))
                            .map(res -> ok(String.format(soapResponse, "SUCCESS")));
                } else {
                    final Optional<Card> defaultCardOpt = StreamSupport.stream(cards.spliterator(), true).filter(Card::getCardDefault).findFirst();
                    if (!defaultCardOpt.isPresent()) {
                        Logger.error("Couldn't find default card for specified phone");
                        return F.Promise.pure(ok(String.format(soapResponse, "ERROR")));
                    }
                    final Card defaultCard = defaultCardOpt.get();

                    final F.Promise<CardLoadResponse> cardLoadPromise;
                    if (defaultCard.getType().equals(CardType.VIRTUAL)) {
                        cardLoadPromise = cardProvider.loadVirtualCardFromCard(defaultCard, amount, currency, "Worldpay deposit");
                    } else {
                        cardLoadPromise = cardProvider.loadPlasticCardFromCard(defaultCard, amount, currency, "Worldpay deposit");
                    }

                    return cardLoadPromise.flatMap(cardLoadResponse -> operationService.createDepositOperation(defaultCard,
                            amount, currency, "" + System.currentTimeMillis(), "Worldpay deposit")).map(res -> ok(String.format(soapResponse, "SUCCESS")));
                }
            });
        });

        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return ok(String.format(soapResponse, "ERROR"));
        });
    }
}
