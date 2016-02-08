package provider;

import exception.CardProviderException;
import model.Currency;
import model.Customer;
import scala.concurrent.Future;

import java.rmi.RemoteException;

/**
 * Card provider interface
 *
 * @author corbandalas - created 08.02.2016
 * @since 0.1.0
 */
public interface CardProvider {

    Future<String> issuePlasticCard(Customer customer, String name, Currency currency) throws RemoteException,
            CardProviderException;

    Future<String> issueVirtualCard(Customer customer,
                                    String name, Currency currency) throws RemoteException,
            CardProviderException;

    Future<String> fundVirtualCard(String virtualCardReference, long amount,
                                   Currency currency) throws RemoteException, CardProviderException;

    Future<String> fundPlasticCard(String plasticCardReference, long amount,
                                   Currency currency) throws RemoteException, CardProviderException;


}
