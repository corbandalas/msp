package provider;

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
public interface CardProvider {

    F.Promise<CardCreationResponse> issueEmptyVirtualCard(Customer customer, String cardName, Currency currency);
    F.Promise<CardCreationResponse> issueEmptyPlasticCard(Customer customer, String cardName, Currency currency);
    F.Promise<CardCreationResponse> issuePrepaidVirtualCard(Customer customer, String cardName, long amount, Currency currency);
    F.Promise<CardCreationResponse> issuePrepaidPlasticCard(Customer customer, String cardName, long amount, Currency currency);
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
    F.Promise<ConvertVirtualToPlasticResponse> convertVirtualToPlastic(Card card, java.util.Date convertDate, boolean applyFee, Date expDate);
    F.Promise<PhoneActivateResponse> activateCardByPhone(Card card);
    F.Promise<CardStatusChangeResponseResponse> blockCard(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> activateCard(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardLost(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardStolen(Card card, String reason);
    F.Promise<CardStatusChangeResponseResponse> reportCardDamaged(Card card, String reason);
}
