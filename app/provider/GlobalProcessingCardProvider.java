package provider;

import ae.globalprocessing.hyperionweb.*;
import akka.actor.ActorSystem;
import com.google.inject.Inject;
import exception.CardProviderException;
import exception.WrongCountryException;
import exception.WrongPropertyException;
import model.*;
import model.Card;
import model.Currency;
import model.Customer;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.api.inject.guice.GuiceApplicationBuilder;
import play.libs.Akka;
import play.libs.F;
import provider.dto.*;
import repository.CountryRepository;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import scala.concurrent.ExecutionContext;
import util.CurrencyUtil;
import util.DateUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Global Processing(GPS) CardProvider implementation
 *
 * @author corbandalas - created 08.02.2016
 * @since 0.2.0
 */

@CardProviderVendor(value = "gps")
public class GlobalProcessingCardProvider implements CardProvider {

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });

    }

    @Inject
    private PropertyRepository propertyRepository;

    @Inject
    private CountryRepository countryRepository;

    @Inject
    private CurrencyRepository currencyRepository;

    @Override
    public F.Promise<CardCreationResponse> issueEmptyVirtualCard(Customer customer, String cardName, Currency currency) {
        return issueCard(customer, cardName, 0, currency, GlobalProcessingCardCreateType.MASTER_VIRTUAL, true);
    }

    @Override
    public F.Promise<CardCreationResponse> issueEmptyPlasticCard(Customer customer, String cardName, Currency currency) {

        return issueCard(customer, cardName, 0, currency, GlobalProcessingCardCreateType.PHYSICAL_WITH_AMOUNT, false);
    }

    @Override
    public F.Promise<CardCreationResponse> issuePrepaidVirtualCard(Customer customer, String cardName, long amount, Currency currency) {
        return issueCard(customer, cardName, amount, currency, GlobalProcessingCardCreateType.VIRTUAL_WITH_AMOUNT, true);
    }

    @Override
    public F.Promise<CardCreationResponse> issuePrepaidPlasticCard(Customer customer, String cardName, long amount, Currency currency) {
        return issueCard(customer, cardName, amount, currency, GlobalProcessingCardCreateType.PHYSICAL_WITH_AMOUNT, true);
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
        return getGPSSettings().flatMap(res -> invokeCardDetails(res, card)).map((res -> new CardDetailsResponse(res.getPublicToken(), res.getMaskedPAN(), res.getExpDate(), null, res.getAvlBal(), res.getCurCode(), res.getStatCode(), res.getActionCode())));
    }

    @Override
    public F.Promise<CardDetailsResponse> getPlasticCardDetails(Card card) {
        return getGPSSettings().flatMap(res -> invokeCardDetails(res, card)).map((res -> new CardDetailsResponse(res.getPublicToken(), res.getMaskedPAN(), res.getExpDate(), null, res.getAvlBal(), res.getCurCode(), res.getStatCode(), res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadVirtualCardFromBank(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, Optional.ofNullable(currency), res._2), description, "6")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadVirtualCardFromCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, Optional.ofNullable(currency), res._2), description, "3")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadPlasticCardFromBank(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, Optional.ofNullable(currency), res._2), description, "6")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardLoadResponse> loadPlasticCardFromCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardLoad(res._1, card, CurrencyUtil.convert(amount, Optional.ofNullable(currency), res._2), description, "3")).map((res -> new CardLoadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardUnloadResponse> unloadPlasticCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardUnload(res._1, card, CurrencyUtil.convert(amount, Optional.ofNullable(currency), res._2), description, "3")).map((res -> new CardUnloadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardUnloadResponse> unloadVirtualCard(Card card, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()))).flatMap(res -> invokeCardUnload(res._1, card, CurrencyUtil.convert(amount, Optional.ofNullable(currency), res._2), description, "3")).map((res -> new CardUnloadResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardTransferBalanceResponse> transferBetweenCards(Card sourceCard, Card destinationCard, long amount, Currency currency, String description) {
        return getGPSSettings().zip(F.Promise.wrap(currencyRepository.retrieveById(sourceCard.getCurrencyId()))).flatMap(res -> invokeCardTransfer(res._1, sourceCard, destinationCard, CurrencyUtil.convert(amount, Optional.ofNullable(currency), res._2), description)).map((res -> new CardTransferBalanceResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<UpdateCustomerResponse> updateCardHolder(Customer customer, Card defaultCard) {
        return getGPSSettings().zip(F.Promise.wrap(countryRepository.retrieveById(customer.getCountry_id()))).
                flatMap(res -> invokeUpdateCardHolder(res, customer, defaultCard)).
                map(res -> new UpdateCustomerResponse(res.getActionCode()));
    }

    @Override
    public F.Promise<ConvertVirtualToPlasticResponse> convertVirtualToPlastic(Customer customer, Card card, Date convertDate, boolean applyFee, Date expDate) {
        return getGPSSettings().flatMap(res -> invokeChangeVirtualToPlastic(res, card, convertDate, applyFee, expDate).zip(changeCardGroup(customer, card))).map((rez -> new ConvertVirtualToPlasticResponse(rez._1.getActionCode())
        ));

    }


    @Override
    public F.Promise<PhoneActivateResponse> activateCardByPhone(Card card) {
        return getGPSSettings().flatMap(res -> invokePhonePlasticCardActivation(res, card)).map((rez -> new PhoneActivateResponse(rez.getActionCode(), rez.isIsLive(), rez.getPinBlock(), "" + rez.getPINStatus())));
    }

    @Override
    public F.Promise<PlasticCardActivateResponse> activatePlasticCard(Card card, String cardNumber, String cvv) {
        return getGPSSettings().flatMap(res -> invokePlasticCardActivation(res, card, cardNumber, cvv)).map((rez -> new PlasticCardActivateResponse(rez.getActionCode(), rez.isIsLive())));
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

    @Override
    public F.Promise<CardTransactionListResponse> getCardTransactions(Card card, Date startDate, Date endDate) {
        return getGPSSettings().flatMap(res -> invokeCardStatement(res, card, startDate, endDate)).map((res -> new CardTransactionListResponse(res.getActionCode(), res.getTransactions() != null ? res.getTransactions().getTransaction2() : null)));
    }

    @Override
    public F.Promise<ChangePINResponse> changePIN(Card card, String currentPIN, String newPIN, String confirmNewPIN) {
        return getGPSSettings().flatMap(res -> invokePinControl(res, card, currentPIN, newPIN, confirmNewPIN, "02")).map((res -> new ChangePINResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<ChangePINResponse> obtainPIN(Card card) {
        return getGPSSettings().flatMap(res -> invokePinControl(res, card, null, null, null, "01")).map((res -> new ChangePINResponse(res.getActionCode())));
    }

    @Override
    public F.Promise<CardDetailsResponse> regenerateCardDetails(Card card) {
        return getGPSSettings().flatMap(res -> invokeCardRegenerate(res, card)).map((res -> new CardDetailsResponse(res.getPublicToken(), res.getPAN(), null, res.getCVV(), 0.0, null, null, res.getActionCode())));
    }

    private F.Promise<CardCreationResponse> issueCard(Customer customer, String cardName, long loadValue, Currency currency, GlobalProcessingCardCreateType type, boolean activateNow) {


        return getGPSSettings().zip(F.Promise.wrap(countryRepository.retrieveById(customer.getCountry_id()))).
                flatMap(res -> invokeCreateCard(res, customer, cardName, loadValue, currency, type, activateNow)).
                map(res -> new CardCreationResponse(res.getPublicToken(), res.getActionCode(), res.getCVV(), res.getMaskedPAN(), res.getExpDate(), res.getLoadValue()));

    }

    @Override
    public F.Promise<ChangeGroup> changeCardGroup(Customer customer, Card card) {
        return getGPSSettings().flatMap(res -> invokeCardChangeGroup(res, customer, card));
    }

    private F.Promise<VirtualCards> invokeCreateCard(F.Tuple<GPSSettings, Optional<Country>> countrySettingsTuple, Customer customer, String cardName, long loadValue, Currency currency, GlobalProcessingCardCreateType type, boolean activateNow) {

        return F.Promise.promise(() -> {

            Service service = getService(countrySettingsTuple._1.wsdlURL);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -25);
            String dob = DateUtil.format(calendar.getTime(), "yyyy-MM-dd");

            if (customer.getDateBirth() != null)
                dob = DateUtil.format(customer.getDateBirth(), "yyyy-MM-dd");

            VirtualCards virtualCards = null;

            System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WsCreateCard service invocation. WSID #" + wsid);

            try {


//                Product ID: 1822
//                Scheme: MySafePay
//                Product Name: MySafePay EUR DE
//                Product Description: MySafePay EUR DE
//                Product Type: 01-Mastercard
//                Card Type: Chip ver Paywave
//                Prograd ID: SPADEE
//                Emboss name: Personalised
//                SubBin Low: 51750961
//                SubBin High: 51750961
//                Hanging filer in days: 10
//                Bank: IDT - 10087
//                AuthID Response - Full Random
//                Group Limit: SafePay SDD Velocity EUR SPA-VL-001
//                Group usage: SafePay Virtual Card Usage
//                Group AuthFee: SafePay Auth Fee Group EUR
//                Group Webservice: SafePay Webservice Fee EUR
//                Card Product: MCRD-Mastercard
//                Service code: 221
//                GPS/FEV/Validity 1095 days
//                Country of issaunce : Germany
//                Billing currency: EUR
//                Settling currency: EUR


                HashMap<String, String> cardDesignMap = new HashMap<String, String>();

                System.out.println("cardDesign = " + countrySettingsTuple._1.cardDesign);

                cardDesignMap.put("EUR", StringUtils.split(countrySettingsTuple._1.cardDesign, "|")[0]);
                cardDesignMap.put("DKK", StringUtils.split(countrySettingsTuple._1.cardDesign, "|")[1]);
                cardDesignMap.put("GBP", StringUtils.split(countrySettingsTuple._1.cardDesign, "|")[2]);

                String cardDesign = cardDesignMap.get(currency.getId());

                System.out.println("cardDesign = " + cardDesign);

                HashMap<String, String> limitGroupMap = new HashMap<String, String>();

                System.out.println("limitGroup = " + countrySettingsTuple._1.limitGroup);

                limitGroupMap.put("EUR_FULL_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.limitGroup, "|")[0]);
                limitGroupMap.put("DKK_FULL_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.limitGroup, "|")[2]);
                limitGroupMap.put("GBP_FULL_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.limitGroup, "|")[4]);

                limitGroupMap.put("EUR_SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.limitGroup, "|")[1]);
                limitGroupMap.put("DKK_SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.limitGroup, "|")[3]);
                limitGroupMap.put("GBP_SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.limitGroup, "|")[5]);

                String limitGroup = limitGroupMap.get(currency.getId() + "_" + customer.getKyc().name());

                System.out.println(customer.getKyc().name());



                System.out.println("limitGroup = " + limitGroup);

                HashMap<String, String> feeGroupMap = new HashMap<String, String>();

                feeGroupMap.put("EUR", StringUtils.split(countrySettingsTuple._1.feeGroup, "|")[0]);
                feeGroupMap.put("DKK", StringUtils.split(countrySettingsTuple._1.feeGroup, "|")[1]);
                feeGroupMap.put("GBP", StringUtils.split(countrySettingsTuple._1.feeGroup, "|")[2]);

                String feeGroup = feeGroupMap.get(currency.getId());

                HashMap<String, String> permGroupMap = new HashMap<String, String>();

//                permGroupMap.put("default", StringUtils.split(countrySettingsTuple._1.permsGroup, "|")[0]);
                permGroupMap.put("SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.permsGroup, "|")[0]);
                permGroupMap.put("FULL_DUE_DILIGENCE", StringUtils.split(countrySettingsTuple._1.permsGroup, "|")[1]);


                String permGroup = permGroupMap.get(customer.getKyc().name());

                System.out.println("permGroup = " + permGroup);


                virtualCards = service.getServiceSoap().wsCreateCard(
                        wsid, //WSID
                        countrySettingsTuple._1.issCode, //IssCode
                        "10", //TxnCode
                        null, //ClientCode
                        customer.getTitle(), //Title
                        customer.getLastName(), //LastName
                        customer.getFirstName(), //FirstName
                        customer.getAddress1(), //Addrl1
                        customer.getAddress2(),//Addrl2
                        customer.getAddress2(), //Addrl3
                        customer.getCity(), //City
                        customer.getPostcode(), //PostCode
                        countrySettingsTuple._2.orElseThrow(WrongCountryException::new).getCode(), //Country
                        customer.getId(), //Mobile
                        cardDesign, //CardDesign
                        null, //ExternalRef
                        dob, //DOB
                        DateUtil.format(new Date(), "yyyy-MM-dd"), //LocDate
                        DateUtil.format(new Date(), "hhmmss"), //LocTime
                        null, //TerminalID
                        loadValue / 100, //LoadValue
                        "" + currency.getId(), //CurCode
                        null, //Reason
                        null, //AccCode
                        0, //ItemSrc
                        "5", //LoadFundsType
                        "67",//countrySettingsTuple._1.loadSrc, //LoadSrc
                        0, //LoadFee
                        customer.getFullName(), //LoadedBy
                        0, //CreateImage
                        type.getValue(), //CreateType
                        null, //CustAccount
                        activateNow ? 1 : 0, //ActivateNow
                        null, //Source_desc
                        null, //ExpDate
                        cardName, //CardName
                        limitGroup, //LimitsGroup
                        null, //MCCGroup
                        permGroup, //PERMSGroup
                        countrySettingsTuple._1.productRef, //ProductRef 1822
                        null, //CarrierType
                        null, //Fulfil1
                        null, //Fulfil2
                        "0", //DelvMethod
                        null, //ThermalLine1
                        null, //ThermalLine2
                        null, //EmbossLine4
                        null, //ImageId
                        null, //LogoFrontId
                        null, //LogoBackId
                        false, //Replacement
                        feeGroup, //FeeGroup
                        null, //PrimaryToken
                        customer.getAddress1(), //Delv_AddrL1
                        customer.getAddress2(), //Delv_AddrL2
                        customer.getAddress2(), //Delv_AddrL3
                        customer.getCity(), //Delv_City
                        customer.getAddress2(), //Delv_County
                        customer.getPostcode(), //Delv_PostCode
                        countrySettingsTuple._2.orElseThrow(WrongCountryException::new).getCode(), //Delv_Country
                        null, //Delv_Code
                        "En", //Lang
                        "1", //Sms_Required
                        null, //SchedFeeGroup
                        null, //WSFeeGroup
                        null, //CardManufacturer
                        null, //CoBrand
                        null, //PublicToken
                        null, //ExternalAuth
                        null, //LinkageGroup
                        null, //VanityName
                        null, //PBlock
                        null, //PINMailer
                        null, //FxGroup
                        customer.getEmail(), //Email
                        "0", //MailOrSMS
                        null, //AuthCalendarGroup
                        null, //Quantity
                        null, //LoadToken
                        createAuthHeader(countrySettingsTuple._1.headerUsername, countrySettingsTuple._1.headerPassword));


                Logger.info("/////// WsCreateCard service invocation was ended. WSID #" + wsid + ". Result code: " + virtualCards.getActionCode() + " ." + virtualCards.toString());

                if (!StringUtils.equals("000", virtualCards.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }


            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return virtualCards;
        }, getExecutionContext());
    }

    private F.Promise<BalanceEnquire2> invokeCardBalance(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

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
        }, getExecutionContext());
    }

    private F.Promise<Card2> invokeCardDetails(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

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
        }, getExecutionContext());
    }


    private F.Promise<LoadCard> invokeCardLoad(GPSSettings gpsSettings, Card card, long amount, String description, String loadType) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

            LoadCard loadCard = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Load service invocation. WSID #" + wsid);

            try {

                loadCard = service.getServiceSoap().wsLoad(wsid, gpsSettings.issCode, "20", null, "1", null, null, card.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
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
        }, getExecutionContext());
    }

    private F.Promise<UnLoad> invokeCardUnload(GPSSettings gpsSettings, Card card, long amount, String description, String loadType) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

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
        }, getExecutionContext());
    }


    private F.Promise<BalanceTransfer> invokeCardTransfer(GPSSettings gpsSettings, Card cardSource, Card cardDestination, long amount, String description) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

            BalanceTransfer balanceTransfer = null;

            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Transfer service invocation. WSID #" + wsid);

            try {

                balanceTransfer = service.getServiceSoap().wsBalanceTransfer(wsid, gpsSettings.issCode, "7", null, "1", null, null, cardSource.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, null, cardDestination.getToken(), (double) amount / 100, cardSource.getCurrencyId(), /*gpsSettings.loadSrc*/"48", 0, null, 0, description, null, null, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// Ws_Transfer service invocation was ended. WSID #" + wsid + ". Result code: " + balanceTransfer.getActionCode() + " ." + balanceTransfer.toString());

                if (!StringUtils.equals("000", balanceTransfer.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return balanceTransfer;
        }, getExecutionContext());
    }


    private F.Promise<CustomerUpdate> invokeUpdateCardHolder(F.Tuple<GPSSettings, Optional<Country>> countrySettingsTuple, Customer customer, Card card) {

        return F.Promise.promise(() -> {

            final GPSSettings gpsSettings = countrySettingsTuple._1;
            final Country country = countrySettingsTuple._2.orElseThrow(WrongCountryException::new);

            Service service = getService(gpsSettings.wsdlURL);

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WS_Update_CardHolder service invocation. WSID #" + wsid);


            CustomerUpdate customerUpdate = null;

            try {

                customerUpdate = service.getServiceSoap().wsUpdateCardholderDetails(wsid, gpsSettings.issCode, "13", null, "1", null, null, null, null, null, null, null, customer.getLastName(), customer.getTitle(), customer.getFirstName(), customer.getAddress1(), customer.getAddress2(), customer.getCity(),
                        customer.getPostcode(), country.getCode(), customer.getId(), null, null, null, null, null, null, null, null, null, customer.getEmail(), null, customer.getId(), null, null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, 0, null, 2, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, 0, 0, 4, 15, 0, 0, null, 0, card.getToken(), 0, null, null, null, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));


                Logger.info("/////// WS_Update_CardHolder service invocation was ended. WSID #" + wsid + ". Result code: " + customerUpdate.getActionCode() + " ." + customerUpdate.toString());

                if (!StringUtils.equals("000", customerUpdate.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return customerUpdate;
        }, getExecutionContext());
    }


    private F.Promise<ConvertCard> invokeChangeVirtualToPlastic(GPSSettings gpsSettings, Card card, Date convertDate, boolean applyFee, Date expDate) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);


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
        }, getExecutionContext());
    }


    private F.Promise<PhoneActivate> invokePhonePlasticCardActivation(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);


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
        }, getExecutionContext());
    }


    private F.Promise<Activate> invokePlasticCardActivation(GPSSettings gpsSettings, Card card, String cardNumber, String cvv) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Activate service invocation. WSID #" + wsid);

            Activate wsActivate = null;

            System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");


            try {
                wsActivate = service.getServiceSoap().wsActivate(wsid, gpsSettings.issCode, "0", null, null, null, null, null, null, null, null, null, "2", cardNumber, null, card.getToken(), null, cvv, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), "Plastic card activation", 0, 0, null, 0, "2", createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// Ws_Activate service invocation was ended. WSID #" + wsid + ". Result code: " + wsActivate.getActionCode() + " ." + wsActivate.toString());

                if (!StringUtils.equals("000", wsActivate.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return wsActivate;
        }, getExecutionContext());
    }


    private F.Promise<StatusChange> invokeStatusChange(GPSSettings gpsSettings, Card card, String statCode, String reason) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);


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
        }, getExecutionContext());
    }


    private F.Promise<CardStatement2> invokeCardStatement(GPSSettings gpsSettings, Card card, Date startDate, Date endDate) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Card_Statement service invocation. WSID #" + wsid);

            CardStatement2 cardStatement = null;

            try {

                cardStatement = service.getServiceSoap().wsCardStatement(wsid, gpsSettings.issCode, "5", null, 2, "1", null, null, card.getToken(), null, null, null, null, DateUtil.format(new Date(), "yyyy-MM-dd"),
                        DateUtil.format(new Date(), "hhmmss"), null, 0, null, 0, "0", DateUtil.format(startDate, "yyyy-MM-dd"), DateUtil.format(endDate, "yyyy-MM-dd"), 0, 0, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// Ws_Card_Statement service invocation was ended. WSID #" + wsid + ". Result code: " + cardStatement.getActionCode() + " ." + cardStatement.toString());

                if (!StringUtils.equals("000", cardStatement.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return cardStatement;
        }, getExecutionContext());
    }

    private F.Promise<PINControl> invokePinControl(GPSSettings gpsSettings, Card card, String oldPin, String newPin, String confirmPin, String func) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);

            long wsid = System.currentTimeMillis();
            Logger.info("/////// WS_PinControl service invocation. WSID #" + wsid);

            PINControl pinControl = null;

            try {

                pinControl = service.getServiceSoap().wsPinControl(wsid, gpsSettings.issCode, DateUtil.format(new Date(), "yyyy-MM-dd"), DateUtil.format(new Date(), "yyyy-MM-dd"), null, card.getToken(), null, func, oldPin, newPin, confirmPin, "1", "1", null, null, null, null, null, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// WS_PinControl service invocation was ended. WSID #" + wsid + ". Result code: " + pinControl.getActionCode() + " ." + pinControl.toString());

                if (!StringUtils.equals("000", pinControl.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return pinControl;
        }, getExecutionContext());
    }

    private F.Promise<CardRegenerate> invokeCardRegenerate(GPSSettings gpsSettings, Card card) {

        return F.Promise.promise(() -> {

            Service service = getService(gpsSettings.wsdlURL);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// WS_Regenerate service invocation. WSID #" + wsid);

            CardRegenerate cardRegenerate = null;

            try {

                cardRegenerate = service.getServiceSoap().wsRegenerateCardDetail(card.getToken(), 0, 1, 1, createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));

                Logger.info("/////// WS_Regenerate service invocation was ended. WSID #" + wsid + ". Result code: " + cardRegenerate.getActionCode() + " ." + cardRegenerate.toString());

                if (!StringUtils.equals("000", cardRegenerate.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return cardRegenerate;
        }, getExecutionContext());
    }


    private F.Promise<ChangeGroup> invokeCardChangeGroup(GPSSettings gpsSettings, Customer customer, Card card) {

        return F.Promise.promise(() -> {

            long wsid = System.currentTimeMillis();
            Logger.info("/////// Ws_Change_Group service invocation. WSID #" + wsid );

            Service service = getService(gpsSettings.wsdlURL);

            ChangeGroup changeGroup = null;

            try {


                HashMap<String, String> permGroupMap = new HashMap<String, String>();

                permGroupMap.put("SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(gpsSettings.permsGroup, "|")[0]);
                permGroupMap.put("FULL_DUE_DILIGENCE", StringUtils.split(gpsSettings.permsGroup, "|")[1]);

                String permGroup = permGroupMap.get(customer.getKyc().name());

                System.out.println(permGroup);

                HashMap<String, String> limitGroupMap = new HashMap<String, String>();

                limitGroupMap.put("EUR_FULL_DUE_DILIGENCE", StringUtils.split(gpsSettings.limitGroup, "|")[0]);
                limitGroupMap.put("DKK_FULL_DUE_DILIGENCE", StringUtils.split(gpsSettings.limitGroup, "|")[2]);
                limitGroupMap.put("GBP_FULL_DUE_DILIGENCE", StringUtils.split(gpsSettings.limitGroup, "|")[4]);


                limitGroupMap.put("EUR_SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(gpsSettings.limitGroup, "|")[1]);
                limitGroupMap.put("DKK_SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(gpsSettings.limitGroup, "|")[3]);
                limitGroupMap.put("GBP_SIMPLIFIED_DUE_DILIGENCE", StringUtils.split(gpsSettings.limitGroup, "|")[5]);

                String limitGroup = limitGroupMap.get(card.getCurrencyId() + "_" + customer.getKyc().name());

                System.out.println(limitGroup);

                changeGroup = service.getServiceSoap().wsCardChangeGroups(wsid, gpsSettings.issCode, null, card.getToken(), DateUtil.format(new Date(), "yyyy-MM-dd"), DateUtil.format(new Date(), "yyyy-MM-dd"), limitGroup, "", permGroup, "", "", "", "", "", createAuthHeader(gpsSettings.headerUsername, gpsSettings.headerPassword));


                Logger.info("/////// Ws_Change_Group service invocation was ended. WSID #" + wsid + ". Result code: " + changeGroup.getActionCode() + " ." + changeGroup.toString());

                if (!StringUtils.equals("000", changeGroup.getActionCode())) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("GPS connection error: ", e);
                throw new CardProviderException("GPS error");
            }

            return changeGroup;
        }, getExecutionContext());
    }

    private AuthSoapHeader createAuthHeader(String soapHeaderUsername, String soapHeaderPassword) {
        AuthSoapHeader authHeader = new AuthSoapHeader();
        authHeader.setStrUserName(soapHeaderUsername);
        authHeader.setStrPassword(soapHeaderPassword);

        return authHeader;
    }

    private Service getService(String wsdlURL) {
        try {

            return new Service(new URL(wsdlURL));
        } catch (MalformedURLException e) {
            Logger.error("Error while constructing service by WSDL" + wsdlURL);
        }

        return new Service();
    }


    private ExecutionContext getExecutionContext() {

        ExecutionContext executionContext = null;

        try {
            executionContext = Akka.system().dispatchers().lookup("card-provider-dispatcher").prepare();
        } catch (Exception e) {
            Logger.error("Specific execution context was not found. Trying to get default", e);

            GuiceApplicationBuilder guiceApplicationBuilder = new GuiceApplicationBuilder();

            executionContext = guiceApplicationBuilder.build().injector().instanceOf(ActorSystem.class).dispatcher();

        }


        return executionContext;

    }

    private F.Promise<GPSSettings> getGPSSettings() {

        final F.Promise<Optional<Property>> wsdlPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.url"));
        final F.Promise<Optional<Property>> usernameHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.soap.header.username"));
        final F.Promise<Optional<Property>> passwrodHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.soap.header.password"));
        final F.Promise<Optional<Property>> otherSettingsPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.gps.wsdl.api.settings"));

        return wsdlPromise.zip(usernameHeaderPromise).zip(passwrodHeaderPromise).zip(otherSettingsPromise).map(res -> {

            String url = res._1._1._1.orElseThrow(WrongPropertyException::new).getValue();
            String userName = res._1._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String password = res._1._2.orElseThrow(WrongPropertyException::new).getValue();

            String gpsConfigStringValue = res._2.orElseThrow(WrongPropertyException::new).getValue();

            String[] split = gpsConfigStringValue.split(":");

            return new GPSSettings(url, userName, password, split[0], split[1], split[2], split[3], split[4], split[5], split[6]);

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
        private String productRef;

        public GPSSettings(String wsdlURL, String headerUsername, String headerPassword, String issCode, String cardDesign, String limitGroup, String permsGroup, String feeGroup, String loadSrc, String productRef) {

            this.wsdlURL = wsdlURL;
            this.headerUsername = headerUsername;
            this.headerPassword = headerPassword;
            this.issCode = issCode;
            this.cardDesign = cardDesign;
            this.limitGroup = limitGroup;
            this.permsGroup = permsGroup;
            this.feeGroup = feeGroup;
            this.loadSrc = loadSrc;
            this.productRef = productRef;

        }

    }

}
