
package com.envoyservices.merchantapi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServiceSoap", targetNamespace = "http://merchantapi.envoyservices.com")
@XmlSeeAlso({
    com.envoyservices.epacsapi.ObjectFactory.class,
    com.envoyservices.merchantapi.ObjectFactory.class
})
public interface ServiceSoap {


    /**
     * 
     * @param auth
     * @return
     *     returns com.envoyservices.merchantapi.PayoutCountriesResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/getPayoutCountries")
    @WebResult(name = "getPayoutCountriesResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "getPayoutCountries", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPayoutCountries")
    @ResponseWrapper(localName = "getPayoutCountriesResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPayoutCountriesResponse")
    public PayoutCountriesResponse getPayoutCountries(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth);

    /**
     * 
     * @param country
     * @param auth
     * @param routeType
     * @return
     *     returns com.envoyservices.merchantapi.PayoutCurrenciesResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/getPayoutCurrenciesByCountry")
    @WebResult(name = "getPayoutCurrenciesByCountryResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "getPayoutCurrenciesByCountry", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPayoutCurrenciesByCountry")
    @ResponseWrapper(localName = "getPayoutCurrenciesByCountryResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPayoutCurrenciesByCountryResponse")
    public PayoutCurrenciesResponse getPayoutCurrenciesByCountry(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "country", targetNamespace = "http://merchantapi.envoyservices.com")
        String country,
        @WebParam(name = "routeType", targetNamespace = "http://merchantapi.envoyservices.com")
        String routeType);

    /**
     * 
     * @return
     *     returns com.envoyservices.merchantapi.EnvoyHeartbeatResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/getEnvoyHeartbeat")
    @WebResult(name = "getEnvoyHeartbeatResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "getEnvoyHeartbeat", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetEnvoyHeartbeat")
    @ResponseWrapper(localName = "getEnvoyHeartbeatResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetEnvoyHeartbeatResponse")
    public EnvoyHeartbeatResponse getEnvoyHeartbeat();

    /**
     * 
     * @param auth
     * @param requestReference
     * @param paymentInstructions
     * @return
     *     returns com.envoyservices.merchantapi.PaymentResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/payToBankAccount")
    @WebResult(name = "payToBankAccountResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "payToBankAccount", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayToBankAccount")
    @ResponseWrapper(localName = "payToBankAccountResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayToBankAccountResponse")
    public PaymentResponse payToBankAccount(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "paymentInstructions", targetNamespace = "http://merchantapi.envoyservices.com")
        ArrayOfPaymentInstruction paymentInstructions);

    /**
     * 
     * @param auth
     * @param requestReference
     * @param paymentInstructions
     * @return
     *     returns com.envoyservices.merchantapi.PaymentResponseV2
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/payToBankAccountV2")
    @WebResult(name = "payToBankAccountV2Result", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "payToBankAccountV2", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayToBankAccountV2")
    @ResponseWrapper(localName = "payToBankAccountV2Response", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayToBankAccountV2Response")
    public PaymentResponseV2 payToBankAccountV2(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "paymentInstructions", targetNamespace = "http://merchantapi.envoyservices.com")
        ArrayOfPaymentInstructionV2 paymentInstructions);

    /**
     * 
     * @param auth
     * @param criteria
     * @param requestReference
     * @return
     *     returns com.envoyservices.merchantapi.PaymentTemplatesResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/getPaymentTemplates")
    @WebResult(name = "getPaymentTemplatesResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "getPaymentTemplates", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPaymentTemplates")
    @ResponseWrapper(localName = "getPaymentTemplatesResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPaymentTemplatesResponse")
    public PaymentTemplatesResponse getPaymentTemplates(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "criteria", targetNamespace = "http://merchantapi.envoyservices.com")
        PaymentTemplatesCriteria criteria);

    /**
     * 
     * @param auth
     * @param criteria
     * @param requestReference
     * @return
     *     returns com.envoyservices.merchantapi.PaymentTemplatesResponseV2
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/getPaymentTemplatesV2")
    @WebResult(name = "getPaymentTemplatesV2Result", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "getPaymentTemplatesV2", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPaymentTemplatesV2")
    @ResponseWrapper(localName = "getPaymentTemplatesV2Response", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetPaymentTemplatesV2Response")
    public PaymentTemplatesResponseV2 getPaymentTemplatesV2(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "criteria", targetNamespace = "http://merchantapi.envoyservices.com")
        PaymentTemplatesCriteriaV2 criteria);

    /**
     * 
     * @param refundInstructions
     * @param auth
     * @param requestReference
     * @return
     *     returns com.envoyservices.merchantapi.RefundResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/refundPayin")
    @WebResult(name = "refundPayinResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "refundPayin", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.RefundPayin")
    @ResponseWrapper(localName = "refundPayinResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.RefundPayinResponse")
    public RefundResponse refundPayin(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "refundInstructions", targetNamespace = "http://merchantapi.envoyservices.com")
        ArrayOfRefundInstruction refundInstructions);

    /**
     * 
     * @param refundInstructions
     * @param auth
     * @param requestReference
     * @return
     *     returns com.envoyservices.merchantapi.RefundResponseV2
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/refundPayinV2")
    @WebResult(name = "refundPayinV2Result", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "refundPayinV2", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.RefundPayinV2")
    @ResponseWrapper(localName = "refundPayinV2Response", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.RefundPayinV2Response")
    public RefundResponseV2 refundPayinV2(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "refundInstructions", targetNamespace = "http://merchantapi.envoyservices.com")
        ArrayOfRefundInstructionV2 refundInstructions);

    /**
     * 
     * @param auth
     * @param requestReference
     * @param paymentInstructions
     * @return
     *     returns com.envoyservices.merchantapi.PaymentResponseV3
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/payToBankAccountV3")
    @WebResult(name = "payToBankAccountV3Result", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "payToBankAccountV3", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayToBankAccountV3")
    @ResponseWrapper(localName = "payToBankAccountV3Response", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayToBankAccountV3Response")
    public PaymentResponseV3 payToBankAccountV3(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "paymentInstructions", targetNamespace = "http://merchantapi.envoyservices.com")
        ArrayOfPaymentInstructionV3 paymentInstructions);

    /**
     * 
     * @param auth
     * @param epacsReference
     * @return
     *     returns com.envoyservices.merchantapi.PaymentConfirmation
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/payInConfirmation")
    @WebResult(name = "payInConfirmationResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "payInConfirmation", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayInConfirmation")
    @ResponseWrapper(localName = "payInConfirmationResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayInConfirmationResponse")
    public PaymentConfirmation payInConfirmation(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "epacsReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String epacsReference);

    /**
     * 
     * @param auth
     * @param epacsReference
     * @return
     *     returns com.envoyservices.merchantapi.PaymentConfirmationV2
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/payInConfirmationV2")
    @WebResult(name = "payInConfirmationV2Result", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "payInConfirmationV2", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayInConfirmationV2")
    @ResponseWrapper(localName = "payInConfirmationV2Response", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PayInConfirmationV2Response")
    public PaymentConfirmationV2 payInConfirmationV2(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "epacsReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String epacsReference);

    /**
     * 
     * @param filter
     * @param auth
     * @param requestReference
     * @return
     *     returns com.envoyservices.merchantapi.PollResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/pollPayments")
    @WebResult(name = "pollPaymentsResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "pollPayments", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PollPayments")
    @ResponseWrapper(localName = "pollPaymentsResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PollPaymentsResponse")
    public PollResponse pollPayments(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "filter", targetNamespace = "http://merchantapi.envoyservices.com")
        PollFilter filter);

    /**
     * 
     * @param auth
     * @param requestReference
     * @param externalRef
     * @return
     *     returns com.envoyservices.merchantapi.PollResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/pollPaymentsByReference")
    @WebResult(name = "pollPaymentsByReferenceResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "pollPaymentsByReference", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PollPaymentsByReference")
    @ResponseWrapper(localName = "pollPaymentsByReferenceResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PollPaymentsByReferenceResponse")
    public PollResponse pollPaymentsByReference(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "requestReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String requestReference,
        @WebParam(name = "externalRef", targetNamespace = "http://merchantapi.envoyservices.com")
        String externalRef);

    /**
     * 
     * @param country
     * @param auth
     * @return
     *     returns com.envoyservices.merchantapi.BankDetailsResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/getBankDetails")
    @WebResult(name = "getBankDetailsResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "getBankDetails", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetBankDetails")
    @ResponseWrapper(localName = "getBankDetailsResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetBankDetailsResponse")
    public BankDetailsResponse getBankDetails(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "country", targetNamespace = "http://merchantapi.envoyservices.com")
        String country);

    /**
     * 
     * @param country
     * @param auth
     * @return
     *     returns com.envoyservices.merchantapi.BankDetailsResponseV2
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/getBankDetailsV2")
    @WebResult(name = "getBankDetailsV2Result", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "getBankDetailsV2", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetBankDetailsV2")
    @ResponseWrapper(localName = "getBankDetailsV2Response", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.GetBankDetailsV2Response")
    public BankDetailsResponseV2 getBankDetailsV2(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "country", targetNamespace = "http://merchantapi.envoyservices.com")
        String country);

    /**
     * 
     * @param request
     * @param auth
     * @return
     *     returns com.envoyservices.merchantapi.PaymentRecord
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/paymentRecordConfirmation")
    @WebResult(name = "paymentRecordConfirmationResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "paymentRecordConfirmation", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PaymentRecordConfirmation")
    @ResponseWrapper(localName = "paymentRecordConfirmationResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.PaymentRecordConfirmationResponse")
    public PaymentRecord paymentRecordConfirmation(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "request", targetNamespace = "http://merchantapi.envoyservices.com")
        PaymentRecordRequest request);

    /**
     * 
     * @param auth
     * @param cancelMerchantReference
     * @param cancelInstruction
     * @return
     *     returns com.envoyservices.merchantapi.CancelResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/cancelPayin")
    @WebResult(name = "cancelPayinResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "cancelPayin", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.CancelPayin")
    @ResponseWrapper(localName = "cancelPayinResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.CancelPayinResponse")
    public CancelResponse cancelPayin(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "cancelMerchantReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String cancelMerchantReference,
        @WebParam(name = "cancelInstruction", targetNamespace = "http://merchantapi.envoyservices.com")
        CancelInstruction cancelInstruction);

    /**
     * 
     * @param auth
     * @param cancelMerchantReference
     * @return
     *     returns com.envoyservices.merchantapi.CancelConfirmationResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/cancelPayinConfirmation")
    @WebResult(name = "cancelPayinConfirmationResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "cancelPayinConfirmation", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.CancelPayinConfirmation")
    @ResponseWrapper(localName = "cancelPayinConfirmationResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.CancelPayinConfirmationResponse")
    public CancelConfirmationResponse cancelPayinConfirmation(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "cancelMerchantReference", targetNamespace = "http://merchantapi.envoyservices.com")
        String cancelMerchantReference);

    /**
     * 
     * @param redirectionUrls
     * @param customerReturnValue
     * @param customerAccountDetails
     * @param auth
     * @param oneClickServiceInfo
     * @param paymentData
     * @param customerData
     * @param tokenOrder
     * @return
     *     returns com.envoyservices.merchantapi.OneClickPaymentResponseV2
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/oneClickPaymentRequestV2")
    @WebResult(name = "oneClickPaymentRequestV2Result", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "oneClickPaymentRequestV2", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.OneClickPaymentRequestV2")
    @ResponseWrapper(localName = "oneClickPaymentRequestV2Response", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.OneClickPaymentRequestV2Response")
    public OneClickPaymentResponseV2 oneClickPaymentRequestV2(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "oneClickServiceInfo", targetNamespace = "http://merchantapi.envoyservices.com")
        OneClickServiceInfoV2 oneClickServiceInfo,
        @WebParam(name = "paymentData", targetNamespace = "http://merchantapi.envoyservices.com")
        PaymentData paymentData,
        @WebParam(name = "customerData", targetNamespace = "http://merchantapi.envoyservices.com")
        CustomerDataV2 customerData,
        @WebParam(name = "customerAccountDetails", targetNamespace = "http://merchantapi.envoyservices.com")
        CustomerAccountDetails customerAccountDetails,
        @WebParam(name = "redirectionUrls", targetNamespace = "http://merchantapi.envoyservices.com")
        RedirectionUrls redirectionUrls,
        @WebParam(name = "customerReturnValue", targetNamespace = "http://merchantapi.envoyservices.com")
        String customerReturnValue,
        @WebParam(name = "tokenOrder", targetNamespace = "http://merchantapi.envoyservices.com")
        TokenOrder tokenOrder);

    /**
     * 
     * @param errorUrl
     * @param cancelUrl
     * @param customerAccountDetails
     * @param auth
     * @param oneClickServiceInfo
     * @param paymentData
     * @param successUrl
     * @param customerData
     * @return
     *     returns com.envoyservices.merchantapi.OneClickPaymentResponse
     */
    @WebMethod(action = "http://merchantapi.envoyservices.com/oneClickPaymentRequest")
    @WebResult(name = "oneClickPaymentRequestResult", targetNamespace = "http://merchantapi.envoyservices.com")
    @RequestWrapper(localName = "oneClickPaymentRequest", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.OneClickPaymentRequest")
    @ResponseWrapper(localName = "oneClickPaymentRequestResponse", targetNamespace = "http://merchantapi.envoyservices.com", className = "com.envoyservices.merchantapi.OneClickPaymentRequestResponse")
    public OneClickPaymentResponse oneClickPaymentRequest(
        @WebParam(name = "auth", targetNamespace = "http://merchantapi.envoyservices.com")
        Authentication auth,
        @WebParam(name = "oneClickServiceInfo", targetNamespace = "http://merchantapi.envoyservices.com")
        OneClickServiceInfo oneClickServiceInfo,
        @WebParam(name = "paymentData", targetNamespace = "http://merchantapi.envoyservices.com")
        PaymentData paymentData,
        @WebParam(name = "customerData", targetNamespace = "http://merchantapi.envoyservices.com")
        CustomerData customerData,
        @WebParam(name = "customerAccountDetails", targetNamespace = "http://merchantapi.envoyservices.com")
        CustomerAccountDetails customerAccountDetails,
        @WebParam(name = "successUrl", targetNamespace = "http://merchantapi.envoyservices.com")
        String successUrl,
        @WebParam(name = "cancelUrl", targetNamespace = "http://merchantapi.envoyservices.com")
        String cancelUrl,
        @WebParam(name = "errorUrl", targetNamespace = "http://merchantapi.envoyservices.com")
        String errorUrl);

}