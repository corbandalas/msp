
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.neuromancerlibrary.ServiceRequest;
import org.datacontract.schemas._2004._07.neuromancerlibrary.ServiceResponse;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DocumentUploadRequest;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DocumentUploadResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UploadDocumentDocumentUploadRequest_QNAME = new QName("http://tempuri.org/", "documentUploadRequest");
    private final static QName _KYCCheckResponseKYCCheckResult_QNAME = new QName("http://tempuri.org/", "KYCCheckResult");
    private final static QName _UploadDocumentResponseUploadDocumentResult_QNAME = new QName("http://tempuri.org/", "UploadDocumentResult");
    private final static QName _KYCCheckServiceRequest_QNAME = new QName("http://tempuri.org/", "serviceRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadDocument }
     * 
     */
    public UploadDocument createUploadDocument() {
        return new UploadDocument();
    }

    /**
     * Create an instance of {@link KYCCheckResponse }
     * 
     */
    public KYCCheckResponse createKYCCheckResponse() {
        return new KYCCheckResponse();
    }

    /**
     * Create an instance of {@link KYCCheck }
     * 
     */
    public KYCCheck createKYCCheck() {
        return new KYCCheck();
    }

    /**
     * Create an instance of {@link UploadDocumentResponse }
     * 
     */
    public UploadDocumentResponse createUploadDocumentResponse() {
        return new UploadDocumentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentUploadRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "documentUploadRequest", scope = UploadDocument.class)
    public JAXBElement<DocumentUploadRequest> createUploadDocumentDocumentUploadRequest(DocumentUploadRequest value) {
        return new JAXBElement<DocumentUploadRequest>(_UploadDocumentDocumentUploadRequest_QNAME, DocumentUploadRequest.class, UploadDocument.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "KYCCheckResult", scope = KYCCheckResponse.class)
    public JAXBElement<ServiceResponse> createKYCCheckResponseKYCCheckResult(ServiceResponse value) {
        return new JAXBElement<ServiceResponse>(_KYCCheckResponseKYCCheckResult_QNAME, ServiceResponse.class, KYCCheckResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentUploadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UploadDocumentResult", scope = UploadDocumentResponse.class)
    public JAXBElement<DocumentUploadResponse> createUploadDocumentResponseUploadDocumentResult(DocumentUploadResponse value) {
        return new JAXBElement<DocumentUploadResponse>(_UploadDocumentResponseUploadDocumentResult_QNAME, DocumentUploadResponse.class, UploadDocumentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "serviceRequest", scope = KYCCheck.class)
    public JAXBElement<ServiceRequest> createKYCCheckServiceRequest(ServiceRequest value) {
        return new JAXBElement<ServiceRequest>(_KYCCheckServiceRequest_QNAME, ServiceRequest.class, KYCCheck.class, value);
    }

}
