package provider;

import ae.globalprocessing.hyperionweb.*;
import com.google.inject.ImplementedBy;
import model.Card;
import model.Currency;
import model.Customer;
import play.libs.F;
import provider.dto.*;

import java.util.Date;


/**
 * Card provider interface
 *
 * @author corbandalas - created 08.02.2016
 * @since 0.1.0
 */

@ImplementedBy(GlobalProcessingCardProvider.class)
public interface CardProvider {

    F.Promise<CardCreationResponse> issueEmptyVirtualCard(Customer customer, String cardName, Currency currency);
    F.Promise<CardCreationResponse> issueEmptyPlasticCard(Customer customer, String cardName, Currency currency);
    F.Promise<CardCreationResponse> issueEmptyVirtualCardForPartner(String partnerID, Customer customer, String cardName, Currency currency, boolean activateNow, String cardDesign, String deliveryAddress1, String deliveryCity, String deliveryPostCode, String deliveryCountry, String deliveryMethod, boolean image, String expDate, boolean smsRequired);
    F.Promise<CardCreationResponse> issueEmptyPlasticCardForPartner(String partnerID, Customer customer, String cardName, Currency currency, boolean activateNow, String cardDesign, String deliveryAddress1, String deliveryCity, String deliveryPostCode, String deliveryCountry, String deliveryMethod, boolean image, String expDate, boolean smsRequired);
    F.Promise<CardCreationResponse> issuePrepaidVirtualCard(Customer customer, String cardName, long amount, Currency currency);
    F.Promise<CardCreationResponse> issuePrepaidPlasticCard(Customer customer, String cardName, long amount, Currency currency);
    F.Promise<CardCreationResponse> issuePrepaidVirtualCardForPartner(String partnerID, Customer customer, String cardName, long amount, Currency currency, boolean activateNow, String cardDesign, String deliveryAddress1, String deliveryCity, String deliveryPostCode, String deliveryCountry, String deliveryMethod, boolean image, String expDate, boolean smsRequired);
    F.Promise<CardCreationResponse> issuePrepaidPlasticCardForPartner(String partnerID, Customer customer, String cardName, long amount, Currency currency, boolean activateNow, String cardDesign, String deliveryAddress1, String deliveryCity, String deliveryPostCode, String deliveryCountry, String deliveryMethod, boolean image, String expDate, boolean smsRequired);
    F.Promise<CardBalanceResponse> getVirtualCardBalance(Card card);
    F.Promise<BalanceEnquire2> getVirtualCardBalanceForPartner(String token, String partnerID);
    F.Promise<CardBalanceResponse> getPlasticCardBalance(Card card);
    F.Promise<CardDetailsResponse> getVirtualCardDetails(Card card);
    F.Promise<CardDetailsResponse> getPlasticCardDetails(Card card);
    F.Promise<CardLoadResponse> loadVirtualCardForPartner(String token, long amount, Currency currency, String description, String source, String partnerID);
    F.Promise<CardLoadResponse> loadVirtualCardFromBank(Card card, long amount, Currency currency, String description);
    F.Promise<CardLoadResponse> loadVirtualCardFromCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardLoadResponse> loadPlasticCardFromBank(Card card, long amount, Currency currency, String description);
    F.Promise<CardLoadResponse> loadPlasticCardFromCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardUnloadResponse> unloadPlasticCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardUnloadResponse> unloadVirtualCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardUnloadResponse> unloadVirtualCardForPartner(String token, long amount, Currency currency, String description, String loadType, String partnerID);
    F.Promise<CardTransferBalanceResponse> transferBetweenCards(Card sourceCard, Card destinationCard, long amount, Currency currency, String description);
    F.Promise<UpdateCustomerResponse> updateCardHolder(Customer customer, Card defaultCard);
    F.Promise<CustomerUpdate> updateCardHolderForPartner(String partnerID, String token, Customer customer);
    F.Promise<ConvertVirtualToPlasticResponse> convertVirtualToPlastic(Customer customer, Card card, java.util.Date convertDate, boolean applyFee, Date expDate);
    F.Promise<PhoneActivateResponse> activateCardByPhone(Card card);
    F.Promise<CardStatusChangeResponseResponse> blockCard(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> changeCardStatusForPartner(String token, String partnerID, String status, String reason);
    F.Promise<CardStatusChangeResponseResponse> activateCard(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardLost(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardStolen(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardDamaged(Card card, String reason);
    F.Promise<CardTransactionListResponse> getCardTransactions(Card card, Date startDate, Date endDate);
    F.Promise<CardStatement2> getCardTransactions(String token, Date startDate, Date endDate, String partnerID);
    F.Promise<ChangePINResponse> changePIN(Card card, String currentPIN, String newPIN, String confirmNewPIN);
    F.Promise<PlasticCardActivateResponse> activatePlasticCard(Card card, String cardNumber, String cvv);
    F.Promise<PlasticCardActivateResponse> activatePlasticCardForPartner(String token, String cardNumber, String cvv, String partnerID, String lastName, String firstName, String addrl1, String addrl2, String city, String postCode, String country, String dob);
    F.Promise<PlasticCardActivateResponse> activatePlasticCardForPartnerAnother(String token,  String expDate, String partnerID);
    F.Promise<WsResult> getServiceResultForPartner(String token, String wsid, String partnerID);
    F.Promise<ChangePINResponse> obtainPIN(Card card);
    F.Promise<PINControl> obtainPINForPartner(String token, String partnerID, String sms);
    F.Promise<PINControl> obtainPINForPartner(String token, String partnerID, String func, String fee, String sms);
    F.Promise<CardDetailsResponse> regenerateCardDetails(Card card);
    F.Promise<ChangeGroup> changeCardGroup(Customer customer, Card card);
    F.Promise<ChangeGroup> changeCardGroupForPartner(Card card, String partnerID, String limitGroup, String permGroup, String mccGroup, String feeGroup, String schedGroup, String wsFeeGroup);
    F.Promise<ApplyFees> applyFee(String code, Card card);
    F.Promise<ApplyFees> applyFeeForPartner(String partnerID, String code, Card card, double fee);
    F.Promise<PassCode> getPassCode(String token);
    F.Promise<BalanceTransfer> balanceTransfer(String partnerID, String token, String newToken, double amount, String currency, String description, String loadedBy, String feeWaiver);
    F.Promise<BalanceAdjust> balanceAdjustmentForPartner(String partnerID, String token, double balance, String currencyCode, String debOrCredit, String description, boolean forcePost);
    F.Promise<AlertResponse> sendMessageForPartner(String partnerID, String token, int event);
    F.Promise<ExtendExpiry> extendExpDate(String partnerID, String token, String expDate);
    F.Promise<Regenerate> regenerateCard(Card card, int regenType, int smsRequired, int smsContent, String extRef, String mailOrSms);
    F.Promise<Regenerate> regenerateCardForPartner(String partnerID, String token, int regenType, int smsRequired, int smsContent, String extRef, String mailOrSms);
    }
