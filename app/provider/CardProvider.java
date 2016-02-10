package provider;

import model.Card;
import model.Currency;
import model.Customer;
import play.libs.F;
import provider.dto.CardBalanceResponse;
import provider.dto.CardCreationResponse;
import provider.dto.CardDetailsResponse;
import provider.dto.CardLoadResponse;


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
    F.Promise<CardLoadResponse> loadVirtualCard(Card card, long amount, String description);
    F.Promise<CardLoadResponse> loadPlasticCard(Card card, long amount, String description);
}
