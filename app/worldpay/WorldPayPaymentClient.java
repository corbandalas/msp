package worldpay;

import com.envoyservices.merchantapi.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import exception.CardProviderException;
import exception.WrongPropertyException;
import model.Currency;
import model.Customer;
import model.Property;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import util.DateUtil;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

/**
 * WorldPay gateway client
 *
 * @author corbandalas - created 16.05.2016
 * @since 0.2.0
 */

@Singleton
public class WorldPayPaymentClient {

    @Inject
    private PropertyRepository propertyRepository;

    public F.Promise<OneClickPaymentResponseV2> oneClickPaymentRequest(String serviceName, String paymentMethod, String transactionDescription, String paymentChannel, long amount, Currency currency, Customer customer, String successURL, String cancelURL, String failureURL) {
        return getSettings().flatMap(res -> oneClickPaymentRequestV2(res, serviceName, paymentMethod, transactionDescription, paymentChannel, amount, currency, customer, successURL, cancelURL, failureURL));
    }

    public F.Promise<BankDetailsResponseV2> getBankDetails(String country) {
        return getSettings().flatMap(res -> getBankDetails(res, country));
    }

    private F.Promise<OneClickPaymentResponseV2> oneClickPaymentRequestV2(WorldPaySettings settings, String serviceName, String paymentMethod, String transactionDescription, String paymentChannel, long amount, Currency currency, Customer customer, String successURL, String cancelURL, String failureURL) {

        return F.Promise.promise(() -> {

            Service service = getService(settings.wsdlURL);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// OneClickServiceInfoV2 service invocation. WSID #" + wsid);

            OneClickPaymentResponseV2 oneClickPaymentResponseV2 = null;

            try {

                OneClickServiceInfoV2 oneClickServiceInfoV2 = new OneClickServiceInfoV2();

                oneClickServiceInfoV2.setServiceName(serviceName);
                oneClickServiceInfoV2.setTransactionCategoryCode(serviceName);
                oneClickServiceInfoV2.setTransactionLongDescription(transactionDescription);
                oneClickServiceInfoV2.setLanguageCode("en");
                oneClickServiceInfoV2.setTransactionShortDescription(transactionDescription);
                ArrayOfOneClickServiceData arrayOfOneClickServiceData = new ArrayOfOneClickServiceData();
                oneClickServiceInfoV2.setServiceData(arrayOfOneClickServiceData);

                PaymentData paymentData = new PaymentData();

                paymentData.setCustomerRef("customerRef"); //TODO:

                paymentData.setCountry("uk"); //TODO:
                paymentData.setAmount(new BigDecimal(amount)); //TODO:
                paymentData.setCurrency(currency.getId());
                paymentData.setPaymentMethod(paymentMethod);

                CustomerDataV2 customerDataV2 = new CustomerDataV2();

                customerDataV2.setAddress1(customer.getAddress1());
                customerDataV2.setAddress2(customer.getAddress2());
                customerDataV2.setCity(customer.getCity());
                customerDataV2.setCountry(customer.getCountry_id());
                customerDataV2.setCustomerId(customer.getId());
                customerDataV2.setDateOfBirth(DateUtil.toXmlGregorianCalendar(customer.getDateBirth()));
                customerDataV2.setEmail(customer.getEmail());
                customerDataV2.setFirstName(customer.getFirstName());
                customerDataV2.setLastName(customer.getLastName());
                customerDataV2.setMobile(customer.getId());
                customerDataV2.setPostcode(customer.getPostcode());
                customerDataV2.setTitle(customer.getTitle());

                CustomerAccountDetails customerAccountDetails = new CustomerAccountDetails();

                customerAccountDetails.setPaymentChannel(paymentChannel);

                RedirectionUrls redirectionUrls = new RedirectionUrls();
                redirectionUrls.setSuccessUrl(successURL);
                redirectionUrls.setErrorUrl(failureURL);
                redirectionUrls.setCancelUrl(cancelURL);


                oneClickPaymentResponseV2 = service.getServiceSoap().oneClickPaymentRequestV2(createAuthHeader(settings.headerUsername, settings.headerPassword), oneClickServiceInfoV2, paymentData, customerDataV2, customerAccountDetails, redirectionUrls, "", null);

                Logger.info("/////// OneClickServiceInfoV2 service invocation was ended. WSID #" + wsid + ". Result code: " + oneClickPaymentResponseV2.getStatusCode() + " . Details: " + oneClickPaymentResponseV2.getStatusMessage() + " // " + oneClickPaymentResponseV2.toString());

                if ( 0 != oneClickPaymentResponseV2.getStatusCode()) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("WorldPay connection error: ", e);
                throw new CardProviderException("WorldPay error");
            }

            return oneClickPaymentResponseV2;
        });
    }

    private F.Promise<BankDetailsResponseV2> getBankDetails(WorldPaySettings settings, String country) {

        return F.Promise.promise(() -> {

            Service service = getService(settings.wsdlURL);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// GetBankDetailsV2 service invocation. WSID #" + wsid);

            BankDetailsResponseV2 bankDetailsV2 = null;

            try {


                bankDetailsV2 = service.getServiceSoap().getBankDetailsV2(createAuthHeader(settings.headerUsername, settings.headerPassword), country);


                Logger.info("/////// GetBankDetailsV2 service invocation was ended. WSID #" + wsid + ". Result code: " + bankDetailsV2.getStatusCode() + " . Details: " + bankDetailsV2.getStatusMessage() + " // " + bankDetailsV2.toString());

                if ( 0 != bankDetailsV2.getStatusCode()) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("WorldPay connection error: ", e);
                throw new CardProviderException("WorldPay error");
            }

            return bankDetailsV2;
        });
    }


    private Authentication createAuthHeader(String soapHeaderUsername, String soapHeaderPassword) {
        Authentication authHeader = new Authentication();

        authHeader.setUsername(soapHeaderUsername);
        authHeader.setPassword(soapHeaderPassword);

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

    private F.Promise<WorldPaySettings> getSettings() {

        final F.Promise<Optional<Property>> wsdlPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.wsdl.url"));
        final F.Promise<Optional<Property>> usernameHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.wsdl.soap.header.username"));
        final F.Promise<Optional<Property>> passwrodHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.wsdl.soap.header.password"));

        return wsdlPromise.zip(usernameHeaderPromise).zip(passwrodHeaderPromise).map(res -> {

            String url = res._1._1.orElseThrow(WrongPropertyException::new).getValue();
            String userName = res._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String password = res._2.orElseThrow(WrongPropertyException::new).getValue();
            return new WorldPaySettings(url, userName, password);
        });
    }

    private class WorldPaySettings {

        private String wsdlURL;
        private String headerUsername;
        private String headerPassword;

        public WorldPaySettings(String wsdlURL, String headerUsername, String headerPassword) {
            this.wsdlURL = wsdlURL;
            this.headerUsername = headerUsername;
            this.headerPassword = headerPassword;
        }


    }



}
