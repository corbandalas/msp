
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukcheck;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukcheck package. 
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

    private final static QName _ArrayOfErrorDetail_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "ArrayOfErrorDetail");
    private final static QName _ArrayOfResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "ArrayOfResult");
    private final static QName _Result_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Result");
    private final static QName _ErrorDetail_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "ErrorDetail");
    private final static QName _Errors_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Errors");
    private final static QName _Results_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Results");
    private final static QName _ResultCountry_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Country");
    private final static QName _ResultAddress2_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Address2");
    private final static QName _ResultDirectorNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "DirectorNumber");
    private final static QName _ResultAddress1_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Address1");
    private final static QName _ResultCounty_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "County");
    private final static QName _ResultPostcode_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Postcode");
    private final static QName _ResultBirthDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "BirthDate");
    private final static QName _ResultName_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Name");
    private final static QName _ResultTown_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Town");
    private final static QName _ErrorsErrorDetails_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "ErrorDetails");
    private final static QName _ErrorDetailCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Code");
    private final static QName _ErrorDetailDesc_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", "Desc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukcheck
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorDetail }
     * 
     */
    public ErrorDetail createErrorDetail() {
        return new ErrorDetail();
    }

    /**
     * Create an instance of {@link Errors }
     * 
     */
    public Errors createErrors() {
        return new Errors();
    }

    /**
     * Create an instance of {@link ArrayOfResult }
     * 
     */
    public ArrayOfResult createArrayOfResult() {
        return new ArrayOfResult();
    }

    /**
     * Create an instance of {@link ArrayOfErrorDetail }
     * 
     */
    public ArrayOfErrorDetail createArrayOfErrorDetail() {
        return new ArrayOfErrorDetail();
    }

    /**
     * Create an instance of {@link Results }
     * 
     */
    public Results createResults() {
        return new Results();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfErrorDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "ArrayOfErrorDetail")
    public JAXBElement<ArrayOfErrorDetail> createArrayOfErrorDetail(ArrayOfErrorDetail value) {
        return new JAXBElement<ArrayOfErrorDetail>(_ArrayOfErrorDetail_QNAME, ArrayOfErrorDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "ArrayOfResult")
    public JAXBElement<ArrayOfResult> createArrayOfResult(ArrayOfResult value) {
        return new JAXBElement<ArrayOfResult>(_ArrayOfResult_QNAME, ArrayOfResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Result")
    public JAXBElement<Result> createResult(Result value) {
        return new JAXBElement<Result>(_Result_QNAME, Result.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "ErrorDetail")
    public JAXBElement<ErrorDetail> createErrorDetail(ErrorDetail value) {
        return new JAXBElement<ErrorDetail>(_ErrorDetail_QNAME, ErrorDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Errors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Errors")
    public JAXBElement<Errors> createErrors(Errors value) {
        return new JAXBElement<Errors>(_Errors_QNAME, Errors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Results }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Results")
    public JAXBElement<Results> createResults(Results value) {
        return new JAXBElement<Results>(_Results_QNAME, Results.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Country", scope = Result.class)
    public JAXBElement<String> createResultCountry(String value) {
        return new JAXBElement<String>(_ResultCountry_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Address2", scope = Result.class)
    public JAXBElement<String> createResultAddress2(String value) {
        return new JAXBElement<String>(_ResultAddress2_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "DirectorNumber", scope = Result.class)
    public JAXBElement<String> createResultDirectorNumber(String value) {
        return new JAXBElement<String>(_ResultDirectorNumber_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Address1", scope = Result.class)
    public JAXBElement<String> createResultAddress1(String value) {
        return new JAXBElement<String>(_ResultAddress1_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "County", scope = Result.class)
    public JAXBElement<String> createResultCounty(String value) {
        return new JAXBElement<String>(_ResultCounty_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Postcode", scope = Result.class)
    public JAXBElement<String> createResultPostcode(String value) {
        return new JAXBElement<String>(_ResultPostcode_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "BirthDate", scope = Result.class)
    public JAXBElement<String> createResultBirthDate(String value) {
        return new JAXBElement<String>(_ResultBirthDate_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Name", scope = Result.class)
    public JAXBElement<String> createResultName(String value) {
        return new JAXBElement<String>(_ResultName_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Town", scope = Result.class)
    public JAXBElement<String> createResultTown(String value) {
        return new JAXBElement<String>(_ResultTown_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfErrorDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "ErrorDetails", scope = Errors.class)
    public JAXBElement<ArrayOfErrorDetail> createErrorsErrorDetails(ArrayOfErrorDetail value) {
        return new JAXBElement<ArrayOfErrorDetail>(_ErrorsErrorDetails_QNAME, ArrayOfErrorDetail.class, Errors.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Code", scope = ErrorDetail.class)
    public JAXBElement<String> createErrorDetailCode(String value) {
        return new JAXBElement<String>(_ErrorDetailCode_QNAME, String.class, ErrorDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Desc", scope = ErrorDetail.class)
    public JAXBElement<String> createErrorDetailDesc(String value) {
        return new JAXBElement<String>(_ErrorDetailDesc_QNAME, String.class, ErrorDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", name = "Result", scope = Results.class)
    public JAXBElement<ArrayOfResult> createResultsResult(ArrayOfResult value) {
        return new JAXBElement<ArrayOfResult>(_Result_QNAME, ArrayOfResult.class, Results.class, value);
    }

}
