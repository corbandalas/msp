package provider;

import ae.globalprocessing.hyperionweb.AuthSoapHeader;
import ae.globalprocessing.hyperionweb.Service;
import ae.globalprocessing.hyperionweb.ServiceSoap;
import ae.globalprocessing.hyperionweb.VirtualCards;
import com.google.inject.Inject;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;
import exception.CardProviderException;
import model.Currency;
import model.Customer;
import model.Property;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import scala.concurrent.Future;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;
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

    @Inject
    private PropertyRepository propertyRepository;

    @Override
    public Future<String> issuePlasticCard(Customer customer, String name, Currency currency) throws RemoteException, CardProviderException {
        return null;
    }

    @Override
    public F.Promise<VirtualCards> issueVirtualCard(Customer customer, String name, Currency currency) throws RemoteException, CardProviderException {


        return getGPSSettings().flatMap(res-> invokeCreateCard(res.wsdlURL, res.getHeaderUsername(), res.getHeaderPassword()));

    }

    public F.Promise<VirtualCards> invokeCreateCard(String wsdlURL, String soapHeaderUsername, String soapHeaderPassword) {

        return F.Promise.promise(() -> {

            Service service = getService(wsdlURL);

            ServiceSoap serviceSoap = service.getServiceSoap();

            createAuthSoapHeader((WSBindingProvider) serviceSoap, soapHeaderUsername, soapHeaderPassword);

            return service.getServiceSoap().wsCreateCard(0, "request.getIssCode()", "request.getTxnCode()",
                    "request.getClientCode()", "request.getTitle()", "request.getLastName()", "request.getFirstName()", "request.getAddrl1()",
                    "request.getAddrl2()", "request.getAddrl3()", "request.getCity()", "request.getPostCode()", "request.getCountry()",
                    "request.getMobile()", "request.getCardDesign()", "request.getExternalRef()", "request.getDOB()", "request.getLocDate()",
                    "request.getLocTime()", "request.getTerminalID()", 0, "request.getCurCode()",
                    "request.getReason()", "request.getAccCode()", 0, "request.getLoadFundsType()", "request.getLoadSrc()",
                    0, "request.getLoadedBy()", 0, 0,
                    "request.getCustAccount()", 1, "request.getSourceDesc()", "request.getExpDate()",
                    "request.getCardName()", "request.getLimitsGroup()", "request.getMCCGroup()", "request.getPERMSGroup()",
                    "request.getProductRef()", "request.getCarrierType()", "request.getFulfil1()", "request.getFulfil2()",
                    "request.getDelvMethod()", "request.getThermalLine1()", "request.getThermalLine2()", "request.getEmbossLine4()",
                    "request.getImageId()", "request.getLogoFrontId()", "request.getLogoBackId()", false,
                    "request.getFeeGroup()", "request.getPrimaryToken()", "request.getDelvAddrL1()", "request.getDelvAddrL2()",
                    "request.getDelvAddrL3()", "request.getDelvCity()", "request.getDelvCounty()", "request.getDelvPostCode()",
                    "request.getDelvCountry()", "request.getDelvCode()", "request.getLang()", "request.getSmsRequired()",
                    "request.getSchedFeeGroup()", "request.getWSFeeGroup()", "request.getCardManufacturer()", "request.getCoBrand()",
                    "request.getPublicToken()", "request.getExternalAuth()", "request.getLinkageGroup()", "request.getVanityName()",
                    "request.getPBlock()", "request.getPINMailer()", "request.getFxGroup()", "request.getEmail()", "request.getMailOrSMS()",
                    "request.getAuthCalendarGroup()", "request.getQuantity()", "request.getLoadToken()");
        });
    }


    @Override
    public Future<String> fundVirtualCard(String virtualCardReference, long amount, Currency currency) throws RemoteException, CardProviderException {
        return null;
    }

    @Override
    public Future<String> fundPlasticCard(String plasticCardReference, long amount, Currency currency) throws RemoteException, CardProviderException {
        return null;
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

        return wsdlPromise.zip(usernameHeaderPromise).zip(passwrodHeaderPromise).map(res-> new GPSSettings(res._1._1.getValue(), res._1._2.getValue(), res._2.getValue()));

    }


    private class GPSSettings {

        private String wsdlURL;
        private String headerUsername;
        private String headerPassword;

        public GPSSettings(String wsdlURL, String headerUsername, String headerPassword) {
            this.wsdlURL = wsdlURL;
            this.headerUsername = headerUsername;
            this.headerPassword = headerPassword;
        }

        public String getWsdlURL() {
            return wsdlURL;
        }

        public void setWsdlURL(String wsdlURL) {
            this.wsdlURL = wsdlURL;
        }

        public String getHeaderUsername() {
            return headerUsername;
        }

        public void setHeaderUsername(String headerUsername) {
            this.headerUsername = headerUsername;
        }

        public String getHeaderPassword() {
            return headerPassword;
        }

        public void setHeaderPassword(String headerPassword) {
            this.headerPassword = headerPassword;
        }
    }
}
