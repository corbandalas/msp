package provider;

import ae.globalprocessing.hyperionweb.ApplyFees;
import ae.globalprocessing.hyperionweb.ChangeGroup;
import ae.globalprocessing.hyperionweb.PassCode;
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
    F.Promise<CardCreationResponse> issueEmptyVirtualCardForPartner(String partnerID, Customer customer, String cardName, Currency currency, boolean activateNow);
    F.Promise<CardCreationResponse> issueEmptyPlasticCardForPartner(String partnerID, Customer customer, String cardName, Currency currency, boolean activateNow);
    F.Promise<CardCreationResponse> issuePrepaidVirtualCard(Customer customer, String cardName, long amount, Currency currency);
    F.Promise<CardCreationResponse> issuePrepaidPlasticCard(Customer customer, String cardName, long amount, Currency currency);
    F.Promise<CardCreationResponse> issuePrepaidVirtualCardForPartner(String partnerID, Customer customer, String cardName, long amount, Currency currency, boolean activateNow);
    F.Promise<CardCreationResponse> issuePrepaidPlasticCardForPartner(String partnerID, Customer customer, String cardName, long amount, Currency currency, boolean activateNow);
    F.Promise<CardBalanceResponse> getVirtualCardBalance(Card card);
    F.Promise<CardBalanceResponse> getPlasticCardBalance(Card card);
    F.Promise<CardDetailsResponse> getVirtualCardDetails(Card card);
    F.Promise<CardDetailsResponse> getPlasticCardDetails(Card card);
    F.Promise<CardLoadResponse> loadVirtualCardFromBank(Card card, long amount, Currency currency, String description);
    F.Promise<CardLoadResponse> loadVirtualCardFromCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardLoadResponse> loadPlasticCardFromBank(Card card, long amount, Currency currency, String description);
    F.Promise<CardLoadResponse> loadPlasticCardFromCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardUnloadResponse> unloadPlasticCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardUnloadResponse> unloadVirtualCard(Card card, long amount, Currency currency, String description);
    F.Promise<CardTransferBalanceResponse> transferBetweenCards(Card sourceCard, Card destinationCard, long amount, Currency currency, String description);
    F.Promise<UpdateCustomerResponse> updateCardHolder(Customer customer, Card defaultCard);
    F.Promise<ConvertVirtualToPlasticResponse> convertVirtualToPlastic(Customer customer, Card card, java.util.Date convertDate, boolean applyFee, Date expDate);
    F.Promise<PhoneActivateResponse> activateCardByPhone(Card card);
    F.Promise<CardStatusChangeResponseResponse> blockCard(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> activateCard(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardLost(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardStolen(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardDamaged(Card card, String reason);
    F.Promise<CardTransactionListResponse> getCardTransactions(Card card, Date startDate, Date endDate);
    F.Promise<ChangePINResponse> changePIN(Card card, String currentPIN, String newPIN, String confirmNewPIN);
    F.Promise<PlasticCardActivateResponse> activatePlasticCard(Card card, String cardNumber, String cvv);
    F.Promise<ChangePINResponse> obtainPIN(Card card);
    F.Promise<CardDetailsResponse> regenerateCardDetails(Card card);
    F.Promise<ChangeGroup> changeCardGroup(Customer customer, Card card);
    F.Promise<ApplyFees> applyFee(String code, Card card);
    F.Promise<PassCode> getPassCode(String token);

}
