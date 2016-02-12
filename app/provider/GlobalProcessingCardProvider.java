package provider;

import ae.globalprocessing.hyperionweb.*;
import com.google.inject.Inject;
import exception.CardProviderException;
import model.*;
import model.Card;
import model.Currency;
import model.Customer;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import provider.dto.*;
import repository.CountryRepository;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import util.CurrencyUtil;
import util.DateUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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

    @Inject
    private CurrencyRepository currencyRepository;

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
        return getGPSSettings().flatMap(res -> invokeCardDetails(res, card)).map((res -> new CardDetailsResponse(res.getMaskedPAN(), res.getExpDate(), null, res.getAvlBal(), res.getActionCode())));
    }

    @Override
    public F.Promise<CardDetailsResponse> getPlasticCardDetails(Card card) {
        return getGPSSettings().flatMap(res -> invokeCardDetails(res, card)).map((res -> new CardDetailsResponse(res.getMaskedPAN(), res.getExpDate(), null, res.getAvlBal(), res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadVirtualCardFromBank(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, currency, res._2), description, "6")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadVirtualCardFromCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, currency, res._2), description, "3")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadPlasticCardFromBank(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, currency, res._2), description, "6")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadPlasticCardFromCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, currency, res._2), description, "3")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardUnloadResponse> unloadPlasticCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardUnload(res._1, card, CurrencyUtil.convert(amount, currency, res._2), description, "3")).map((res -> new CardUnloadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardUnloadResponse> unloadVirtualCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardUnload(res._1, card, CurrencyUtil.convert(amount, currency, res._2), description, "3")).map((res -> new CardUnloadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardTransferBalanceResponse> transferBetweenCards(Card sourceCard, Card destinationCard, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(sourceCard.getCurrencyId()))).flatMap(res -> invokeCardTransfer(res._1, sourceCard, destinationCard, CurrencyUtil.convert(amount, currency, res._2), description)).map((res -> new CardTransferBalanceResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<UpdateCustomerResponse> updateCardHolder(Customer customer, Card defaultCard) {
        return getGPSSettings().zip(F.Promise.wrap(countryRepository.retrieveById(customer.getCountry_id()))).
                flatMap(res -> invokeUpdateCardHolder(res, customer, defaultCard)).
                map(res -> new UpdateCustomerResponse(res.getActionCode()));
    }

    @Override
    public F.Promise<ConvertVirtualToPlasticResponse> convertVirtualToPlastic(Card card, Date convertDate, boolean applyFee, Date expDate) {
        return getGPSSettings().flatMap(res -> invokeChangeVirtualToPlastic(res, card, convertDate, applyFee, expDate)).map((rez -> new ConvertVirtualToPlasticResponse(rez.getActionCode())));
    }


    @Override
    public F.Promise<PhoneActivateResponse> activateCardByPhone(Card card) {
        return getGPSSettings().flatMap(res -> invokePlasticCardActivation(res, card)).map((rez -> new PhoneActivateResponse(rez.getActionCode(), rez.isIsLive(), rez.getPinBlock(), "" + rez.getPINStatus())));
    }

    @Override
    public F.Promise<CardStatusChangeResponseResponse> blockCard(Card card, String reason) {
        return getGPSSettings().flatMap(res -> invokeStatusChange(res, card, "05", reason)).map((rez -> new CardStatusChangeResponseResponse(rez.getActionCode())));
    }

    @Override
    public F.Promise<CardStatusChangeResponseResponse> activateCard(Card card, String reason) {
        return getGPSSettings().flatMap(res -> invokeStatusChange(res, card, "00", reason)).map((rez -> new CardStatusChangeResponseResponse(rez.getActionCode())));
    }

    @Override
    public F.Promise<CardStatusChangeResponseResponse> reportCardLost(Card card, String reason) {
        return getGPSSettings().flatMap(res -> invokeStatusChange(res, card, "41", reason)).map((rez -> new CardStatusChangeResponseResponse(rez.getActionCode())));
    }

    @Override
    public F.Promise<CardStatusChangeResponseResponse> reportCardStolen(Card card, String reason) {
        return getGPSSettings().flatMap(res -> invokeStatusChange(res, card, "43", reason)).map((rez -> new CardStatusChangeResponseResponse(rez.getActionCode())));
    }

    @Override
    public F.Promise<CardStatusChangeResponseResponse> reportCardDamaged(Card card, String reason) {
        return getGPSSettings().flatMap(res -> invokeStatusChange(res, card, "83", reason)).map((rez -> new CardStatusChangeResponseResponse(rez.getActionCode())));
    }

    private F.Promise<CardCreationResponse> issueCard(Customer customer, String cardName, long loadValue, Currency currency, GlobalProcessingCardCreateType type, boolean activateNow) {


        return getGPSSettings().zip(F.Promise.wrap(countryRepository.retrieveById(customer.getCountry_id()))).
                flatMap(res -> invokeCreateCard(res, customer, cardName, loadValue, currency, type, activateNow)).
                map(res -> new CardCreationResponse(res.getPublicToken(), res.getActionCode(), res.getCVV(), res.getMaskedPAN(), res.getExpDate()));

    }

    private F.Promise<VirtualCards> invokeCreateCard(F.Tuple<GPSSettings, Country> countrySettingsTuple, Customer customer, String cardName, long loadValue, Currency currency, GlobalProcessingCardCreateType type, boolean activateNow) {

        return F.Promise.promise(() -> {

            Service service = getService(countrySettingsTuple._1.wsdlURL, countrySettingsTuple._1.headerUsername, countrySettingsTuple._1.headerPassword);

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
                        null, "0", null, createAuthHeader(countrySettingsTuple._1.headerUsername, countrySettingsTuple._1.headerPassword));


                Logger.info("/////// WsCreateCard service invocation was ended. WSID #" + wsid + ". Result code: " + virtualCards.getActionCode() + " ." + virtualCards.toString());

                if (!StringUtils.equals("000", virtualCards.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }


            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return virtualCards;
        });
    }

    private F.Promise<BalanceEnquire2> invokeCardBalance(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);

            BalanceEnquire2 balance = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WsBalanceEnquiryV2 service invocation. WSID #" + wsid);

            try {
                balance = service.getServiceSoap().wsBalanceEnquiryV2(wsid, gpsSettings.issCode, "3", null, 4, "1", null, null, card.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, "0", createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// WsBalanceEnquiryV2 service invocation was ended. WSID #" + wsid + ". Result code: " + balance.getActionCode() + " ." + balance.toString());

                if (!StringUtils.equals("000", balance.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return balance;
        });
    }

    private F.Promise<Card2> invokeCardDetails(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);

            Card2 cardDetails = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WsEnquiry service invocation. WSID #" + wsid);

            try {
                cardDetails = service.getServiceSoap().wsEnquiry(System.currentTimeMillis(), gpsSettings.issCode, "9", "1", null, null, null, card.getToken(), null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), 5, null, null, null, null, 0, null, 0, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// WsEnquiry service invocation was ended. WSID #" + wsid + ". Result code: " + cardDetails.getActionCode() + " ." + cardDetails.toString());

                if (!StringUtils.equals("000", cardDetails.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return cardDetails;
        });
    }


    private F.Promise<LoadCard> invokeCardLoad(GPSSettings gpsSettings, Card card, long amount, String description, String loadType) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);

            LoadCard loadCard = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Load service invocation. WSID #" + wsid);

            try {

                loadCard = service.getServiceSoap().wsLoad(wsid, gpsSettings.issCode, "1", null, "1", null, null, card.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, (double) amount / 100, card.getCurrencyId(), loadType, gpsSettings.loadSrc, 0f, 0, null, 0, null, description, null, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// Ws_Load service invocation was ended. WSID #" + wsid + ". Result code: " + loadCard.getActionCode() + " ." + loadCard.toString());

                if (!StringUtils.equals("000", loadCard.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return loadCard;
        });
    }

    private F.Promise<UnLoad> invokeCardUnload(GPSSettings gpsSettings, Card card, long amount, String description, String loadType) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);

            UnLoad unload = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_UnLoad service invocation. WSID #" + wsid);

            try {

                unload = service.getServiceSoap().wsUnLoad(wsid, gpsSettings.issCode, "8", null, "1", null, null, card.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, loadType, gpsSettings.loadSrc, (double) amount / 100, card.getCurrencyId(), 0, null, 0, null, description, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// Ws_UnLoad service invocation was ended. WSID #" + wsid + ". Result code: " + unload.getActionCode() + " ." + unload.toString());

                if (!StringUtils.equals("000", unload.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return unload;
        });
    }


    private F.Promise<BalanceTransfer> invokeCardTransfer(GPSSettings gpsSettings, Card cardSource, Card cardDestination, long amount, String description) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);

            BalanceTransfer balanceTransfer = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Transfer service invocation. WSID #" + wsid);

            try {

                balanceTransfer = service.getServiceSoap().wsBalanceTransfer(wsid, gpsSettings.issCode, "7", null, "1", null, null, cardSource.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, null, cardDestination.getToken(), (double) amount / 100, cardSource.getCurrencyId(), gpsSettings.loadSrc, 0, null, 0, description, null, null, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// Ws_Transfer service invocation was ended. WSID #" + wsid + ". Result code: " + balanceTransfer.getActionCode() + " ." + balanceTransfer.toString());

                if (!StringUtils.equals("000", balanceTransfer.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return balanceTransfer;
        });
    }


    private F.Promise<CustomerUpdate> invokeUpdateCardHolder(F.Tuple<GPSSettings, Country> countrySettingsTuple, Customer customer, Card card) {

        return F.Promise.promise(() -> {

            final GPSSettings gpsSettings = countrySettingsTuple._1;
            final Country country = countrySettingsTuple._2;

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// WS_Update_CardHolder service invocation. WSID #" + wsid);


            CustomerUpdate customerUpdate = null;

            try {

                customerUpdate = service.getServiceSoap().wsUpdateCardholderDetails(wsid, gpsSettings.issCode, "13", null, "1", null, null, null, null, null, null, null, customer.getLastName(), customer.getTitle(), customer.getFirstName(), customer.getAddress1(), customer.getAddress2(), customer.getCity(),
                        customer.getPostcode(), country.getCode(), customer.getId(), null, null, null, null, null, null, null, null, null, customer.getEmail(), null, customer.getId(), null, null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, 0, null, 2, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, 0, card.getToken(), 0, null, null, null, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));


                Logger.info("/////// WS_Update_CardHolder service invocation was ended. WSID #" + wsid + ". Result code: " + customerUpdate.getActionCode() + " ." + customerUpdate.toString());

                if (!StringUtils.equals("000", customerUpdate.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return customerUpdate;
        });
    }


    private F.Promise<ConvertCard> invokeChangeVirtualToPlastic(GPSSettings gpsSettings, Card card, Date convertDate, boolean applyFee, Date expDate) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);


            ConvertCard convertCard = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Convert_Card service invocation. WSID #" + wsid);


            try {

                convertCard = service.getServiceSoap().wsConvertCard(card.getToken(), DateUtil.format(convertDate, "yyyy-MM-dd"), applyFee ? 1 : 0, DateUtil.format(expDate, "yyyy-MM-dd"), createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));


                Logger.info("/////// Ws_Convert_Card service invocation was ended. WSID #" + wsid + ". Result code: " + convertCard.getActionCode() + " ." + convertCard.toString());

                if (!StringUtils.equals("000", convertCard.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return convertCard;
        });
    }



    private F.Promise<PhoneActivate> invokePlasticCardActivation(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);



            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Card_Phone_Activation service invocation. WSID #" + wsid);

            PhoneActivate phoneActivate = null;


            try {

                phoneActivate = service.getServiceSoap().wsPhoneActivation(null, card.getToken(), 0, 1, "1", createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// Ws_Card_Phone_Activation service invocation was ended. WSID #" + wsid + ". Result code: " + phoneActivate.getActionCode() + " ." + phoneActivate.toString());

                if (!StringUtils.equals("000", phoneActivate.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return phoneActivate;
        });
    }


    private F.Promise<StatusChange> invokeStatusChange(GPSSettings gpsSettings, Card card, String statCode, String reason) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);



            long wsid = System.currentTimeMillis();
            Logger.info("/////// WS_StatusChange service invocation. WSID #" + wsid);

            StatusChange statusChange = null;

            try {

                statusChange = service.getServiceSoap().wsStatusChange(wsid, gpsSettings.issCode, "2", null, "1", null, null, card.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), statCode, reason, 2, null, 0, null, 0, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// WS_StatusChange service invocation was ended. WSID #" + wsid + ". Result code: " + statusChange.getActionCode() + " ." + statusChange.toString());

                if (!StringUtils.equals("000", statusChange.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return statusChange;
        });
    }


//    private F.Promise<StatusChange> invokeCardStatement(GPSSettings gpsSettings, Card card, Date startDate, Date endDate) {
//
//        return F.Promise.promise(() -> {
//
//            Service service = getService(gpsSettings.wsdlURL, gpsSettings.headerUsername, gpsSettings.headerPassword);
//
//
//            long wsid = System.currentTimeMillis();
//            Logger.info("/////// Ws_Card_Statement service invocation. WSID #" + wsid);
//
//
//            try {
//
//
//                service.getServiceSoap().wsCardStatement(wsid, gpsSettings.issCode, )
//
//                Logger.info("/////// Ws_Card_Statement service invocation was ended. WSID #" + wsid + ". Result code: " + statusChange.getActionCode() + " ." + statusChange.toString());
//
//                if (!StringUtils.equals("000", statusChange.getActionCode())) {
//                    throw new CardProviderException("Bad Response");
//                }
//
//            } catch (Exception e) {
//                Logger.error("GPS connection error: ", e);
//                throw new CardProviderException("GPS error");
//            }
//
//            return statusChange;
//        });
//    }

    private AuthSoapHeader createAuthHeader(String soapHeaderUsername, String soapHeaderPassword) {
        AuthSoapHeader authHeader = new AuthSoapHeader();
        authHeader.setStrUserName(soapHeaderUsername);
        authHeader.setStrPassword(soapHeaderPassword);

        return authHeader;
    }

    private Service getService(String wsdlURL, String headerUsername, String headerPassword) {
        try {

            Service service = new Service(new URL(wsdlURL));

            ServiceSoap serviceSoap = service.getServiceSoap();

            return service;
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
