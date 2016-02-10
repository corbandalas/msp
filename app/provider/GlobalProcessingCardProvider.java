package provider;

import ae.globalprocessing.hyperionweb.*;
import com.google.inject.Inject;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;
import model.*;
import model.Card;
import model.Customer;
import play.Logger;
import play.libs.F;
import provider.dto.CardBalanceResponse;
import provider.dto.CardCreationResponse;
import provider.dto.CardDetailsResponse;
import repository.CountryRepository;
import repository.PropertyRepository;
import util.DateUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

/**
 * Global Processing(GPS) CardProvider implementation
 *
 * @author corbandalas - created 08.02.2016
 * @since 0.1.0
 */

@CardProviderVendor(value = "gps")
public class GlobalProcessingCardProvider implements CardProvider {

    @Inject
    private PropertyRepository propertyRepository;

    @Inject
    private CountryRepository countryRepository;


    @Override
    public F.Promise<CardCreationResponse> issueEmptyVirtualCard(Customer customer, String cardName, Currency currency) {
        return issueCard(customer, cardName, 0, currency, GlobalProcessingCardCreateType.VIRTUAL_WITH_AMOUNT, false);
    }

    @Override
    public F.Promise<CardCreationResponse> issueEmptyPlasticCard(Customer customer, String cardName, Currency currency) {
        return issueCard(customer, cardName, 0, currency, GlobalProcessingCardCreateType.PHYSICAL_WITH_AMOUNT, false);
    }

    @Override
    public F.Promise<CardCreationResponse> issuePrepaidVirtualCard(Customer customer, String cardName, long amount, Currency currency) {
        return issueCard(customer, cardName, amount, currency, GlobalProcessingCardCreateType.VIRTUAL_WITH_AMOUNT, false);
    }

    @Override
    public F.Promise<CardCreationResponse> issuePrepaidPlasticCard(Customer customer, String cardName, long amount, Currency currency) {
        return issueCard(customer, cardName, amount, currency, GlobalProcessingCardCreateType.PHYSICAL_WITH_AMOUNT, false);
    }

    @Override
    public F.Promise<CardBalanceResponse> getVirtualCardBalance(Card card) {
        return getGPSSettings().flatMap(res -> invokeCardBalance(res, card)).map((res -> new CardBalanceResponse(res.getAvlBal(), res.getCurCode(), res.getActionCode())));
    }

    @Override
    public F.Promise<CardBalanceResponse> getPlasticCardBalance(Card card) {
        return getGPSSettings().flatMap(res -> invokeCardBalance(res, card)).map((res -> new CardBalanceResponse(res.getAvlBal(), res.getCurCode(), res.getActionCode())));
    }

    @Override
    public F.Promise<CardDetailsResponse> getVirtualCardDetails(Card card) {
        return  getGPSSettings().flatMap(res -> invokeCardDetails(res, card)).map((res -> new CardDetailsResponse(res.getMaskedPAN(), res.getExpDate(), null, res.getAvlBal(), res.getActionCode())));
    }

    @Override
    public F.Promise<CardDetailsResponse> getPlasticCardDetails(Card card) {
        return getGPSSettings().flatMap(res -> invokeCardDetails(res, card)).map((res -> new CardDetailsResponse(res.getMaskedPAN(), res.getExpDate(), null, res.getAvlBal(), res.getActionCode())));
    }

    private F.Promise<CardCreationResponse> issueCard(Customer customer, String cardName, long loadValue, Currency currency, GlobalProcessingCardCreateType type, boolean activateNow) {


        return getGPSSettings().zip(F.Promise.wrap(countryRepository.retrieveById(customer.getCountry_id()))).
                flatMap(res -> invokeCreateCard(res, customer, cardName, loadValue, currency, type, activateNow)).
                map(res -> new CardCreationResponse(res.getPublicToken(), res.getActionCode(), res.getCVV(), res.getMaskedPAN(), res.getExpDate()));

    }

    private F.Promise<VirtualCards> invokeCreateCard(F.Tuple<GPSSettings, Country> countrySettingsTuple, Customer customer, String cardName, long loadValue, Currency currency, GlobalProcessingCardCreateType type, boolean activateNow) {

        return F.Promise.promise(() -> {

            Service service = getService(countrySettingsTuple._1.wsdlURL);

            ServiceSoap serviceSoap = service.getServiceSoap();

            createAuthSoapHeader((WSBindingProvider) serviceSoap, countrySettingsTuple._1.headerUsername, countrySettingsTuple._1.headerPassword);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -25);
            String dob = DateUtil.format(calendar.getTime(), "yyyy-MM-dd");

            if (customer.getDateBirth() != null)
                dob = DateUtil.format(customer.getDateBirth(), "yyyy-MM-dd");

            VirtualCards virtualCards = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WsCreateCard service invocation. WSID #" + wsid);

            try {

                virtualCards = service.getServiceSoap().wsCreateCard(wsid, countrySettingsTuple._1.issCode, "10",
                        null, customer.getTitle(), customer.getLastName(), customer.getFirstName(), customer.getAddress1(),
                        customer.getAddress2(), customer.getAddress2(), customer.getCity(), customer.getPostcode(), countrySettingsTuple._2.getCode(),
                        customer.getId(), countrySettingsTuple._1.cardDesign, null, dob, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, loadValue, "" + currency.getCode(),
                        null, null, 0, null, countrySettingsTuple._1.loadSrc,
                        0, null, 0, type.getValue(),
                        null, activateNow ? 1 : 0, null, null,
                        cardName, countrySettingsTuple._1.limitGroup, null, countrySettingsTuple._1.permsGroup,
                        "request.getProductRef()", null, null, null,
                        "0", null, null, null,
                        null, null, null, false,
                        countrySettingsTuple._1.feeGroup, null, customer.getAddress1(), customer.getAddress2(),
                        customer.getAddress2(), customer.getCity(), customer.getAddress2(), customer.getPostcode(),
                        countrySettingsTuple._2.getCode(), null, "En", "1",
                        null, null, null, null,
                        null, null, null, null,
                        null, null, null, customer.getEmail(), "0",
                        null, "0", null);


                Logger.info("/////// WsCreateCard service invocation was ended. WSID #" + wsid + ". Result code: " + virtualCards.getActionCode() + " ." + virtualCards.toString());


            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                F.Promise.throwing(e);
            }

            return virtualCards;
        });
    }

    private F.Promise<BalanceEnquire2> invokeCardBalance(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

            ServiceSoap serviceSoap = service.getServiceSoap();

            createAuthSoapHeader((WSBindingProvider) serviceSoap, gpsSettings.headerUsername, gpsSettings.headerPassword);

            BalanceEnquire2 balance = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WsBalanceEnquiryV2 service invocation. WSID #" + wsid);

            try {
                balance = service.getServiceSoap().wsBalanceEnquiryV2(wsid, gpsSettings.issCode, "3", null, 4, "1", null, null, card.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, "0");

                Logger.info("/////// WsBalanceEnquiryV2 service invocation was ended. WSID #" + wsid + ". Result code: " + balance.getActionCode() + " ." + balance.toString());


            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                F.Promise.throwing(e);
            }

            return balance;
        });
    }

    private F.Promise<Card2> invokeCardDetails(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

            ServiceSoap serviceSoap = service.getServiceSoap();

            createAuthSoapHeader((WSBindingProvider) serviceSoap, gpsSettings.headerUsername, gpsSettings.headerPassword);

            Card2 cardDetails = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WsEnquiry service invocation. WSID #" + wsid);

            try {
                 cardDetails = service.getServiceSoap().wsEnquiry(System.currentTimeMillis(), gpsSettings.issCode, "9", "1", null, null, null, card.getToken(), null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), 5, null, null, null, null, 0, null, 0);

                Logger.info("/////// WsEnquiry service invocation was ended. WSID #" + wsid + ". Result code: " + cardDetails.getActionCode() + " ." + cardDetails.toString());


            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                F.Promise.throwing(e);
            }

            return cardDetails;
        });
    }


    private void createAuthSoapHeader(WSBindingProvider bindingProvider, String soapHeaderUsername, String soapHeaderPassword) {


        AuthSoapHeader authHeader = new AuthSoapHeader();
        authHeader.setStrUserName(soapHeaderUsername);
        authHeader.setStrUserName(soapHeaderPassword);

        try {
            bindingProvider.setOutboundHeaders(Headers.create(JAXBContext.newInstance(AuthSoapHeader.class), authHeader));
        } catch (JAXBException e) {
            Logger.error("XML binding error", e);
        }
    }

    private Service getService(String wsdlURL) {
        try {
            return new Service(new URL(wsdlURL));
        } catch (MalformedURLException e) {
            Logger.error("Error while constructing service by WSDL" + wsdlURL);
        }

        return new Service();
    }

    private F.Promise<GPSSettings> getGPSSettings() {

        final F.Promise<Property> wsdlPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.url"));
        final F.Promise<Property> usernameHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.soap.header.username"));
        final F.Promise<Property> passwrodHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.soap.header.password"));
        final F.Promise<Property> otherSettingsPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.api.settings"));

        return wsdlPromise.zip(usernameHeaderPromise).zip(passwrodHeaderPromise).zip(otherSettingsPromise).map(res -> {

            String url = res._1._1._1.getValue();
            String userName = res._1._1._2.getValue();
            String password = res._1._2.getValue();
            String[] split = res._2.getValue().split(":");

            return new GPSSettings(url, userName, password, split[0], split[1], split[2], split[3], split[4], split[5]);

        });
    }

    private class GPSSettings {

        private String wsdlURL;
        private String headerUsername;
        private String headerPassword;
        private String issCode;
        private String cardDesign;
        private String limitGroup;
        private String permsGroup;
        private String feeGroup;
        private String loadSrc;

        public GPSSettings(String wsdlURL, String headerUsername, String headerPassword, String issCode, String cardDesign, String limitGroup, String permsGroup, String feeGroup, String loadSrc) {

            this.wsdlURL = wsdlURL;
            this.headerUsername = headerUsername;
            this.headerPassword = headerPassword;
            this.issCode = issCode;
            this.cardDesign = cardDesign;
            this.limitGroup = limitGroup;
            this.permsGroup = permsGroup;
            this.feeGroup = feeGroup;
            this.loadSrc = loadSrc;

        }

    }
}
