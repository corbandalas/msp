package provider;

import exception.CardProviderException;
import model.Currency;
import model.Customer;
import scala.concurrent.Future;

import java.rmi.RemoteException;

/**
 * Global Processing(GPS) CardProvider implementation
 *
 * @author corbandalas - created 08.02.2016
 * @since 0.1.0
 *
 */

@CardProviderVendor(value = "gps")
public class GlobalProcessingCardProvider implements CardProvider {

    @Override
    public Future<String> issuePlasticCard(Customer customer, String name, Currency currency) throws RemoteException, CardProviderException {
        return null;
    }

    @Override
    public Future<String> issueVirtualCard(Customer customer, String name, Currency currency) throws RemoteException, CardProviderException {
        return null;
    }

    @Override
    public Future<String> fundVirtualCard(String virtualCardReference, long amount, Currency currency) throws RemoteException, CardProviderException {
        return null;
    }

    @Override
    public Future<String> fundPlasticCard(String plasticCardReference, long amount, Currency currency) throws RemoteException, CardProviderException {
        return null;
    }
}
