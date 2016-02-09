package provider;

import ae.globalprocessing.hyperionweb.VirtualCards;
import model.Currency;
import model.Customer;
import play.libs.F;


/**
 * Card provider interface
 *
 * @author corbandalas - created 08.02.2016
 * @since 0.1.0
 */
public interface CardProvider {

    F.Promise<VirtualCards> issueEmptyVirtualCard(Customer customer, String cardName, Currency currency);
    F.Promise<VirtualCards> issueEmptyPlasticCard(Customer customer, String cardName, Currency currency);
    F.Promise<VirtualCards> issuePrepaidVirtualCard(Customer customer, String cardName, long amount, Currency currency);
    F.Promise<VirtualCards> issuePrepaidPlasticCard(Customer customer, String cardName, long amount, Currency currency);



}
