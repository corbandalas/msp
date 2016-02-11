
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_equifax;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_equifax package. 
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

    private final static QName _AddressMatch_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "AddressMatch");
    private final static QName _ArrayOfAddressMatch_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "ArrayOfAddressMatch");
    private final static QName _AddressMatchHouseName_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "HouseName");
    private final static QName _AddressMatchPoBox_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "PoBox");
    private final static QName _AddressMatchStreet1_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "Street1");
    private final static QName _AddressMatchHouseNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "HouseNumber");
    private final static QName _AddressMatchStreet2_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "Street2");
    private final static QName _AddressMatchAddressId_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "AddressId");
    private final static QName _AddressMatchCounty_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "County");
    private final static QName _AddressMatchDistrict_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "District");
    private final static QName _AddressMatchPostCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "PostCode");
    private final static QName _AddressMatchPostTown_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "PostTown");
    private final static QName _AddressMatchCountry_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "Country");
    private final static QName _AddressMatchSubBuilding_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", "SubBuilding");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_equifax
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddressMatch }
     * 
     */
    public AddressMatch createAddressMatch() {
        return new AddressMatch();
    }

    /**
     * Create an instance of {@link ArrayOfAddressMatch }
     * 
     */
    public ArrayOfAddressMatch createArrayOfAddressMatch() {
        return new ArrayOfAddressMatch();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressMatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "AddressMatch")
    public JAXBElement<AddressMatch> createAddressMatch(AddressMatch value) {
        return new JAXBElement<AddressMatch>(_AddressMatch_QNAME, AddressMatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAddressMatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "ArrayOfAddressMatch")
    public JAXBElement<ArrayOfAddressMatch> createArrayOfAddressMatch(ArrayOfAddressMatch value) {
        return new JAXBElement<ArrayOfAddressMatch>(_ArrayOfAddressMatch_QNAME, ArrayOfAddressMatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "HouseName", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchHouseName(String value) {
        return new JAXBElement<String>(_AddressMatchHouseName_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "PoBox", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchPoBox(String value) {
        return new JAXBElement<String>(_AddressMatchPoBox_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "Street1", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchStreet1(String value) {
        return new JAXBElement<String>(_AddressMatchStreet1_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "HouseNumber", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchHouseNumber(String value) {
        return new JAXBElement<String>(_AddressMatchHouseNumber_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "Street2", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchStreet2(String value) {
        return new JAXBElement<String>(_AddressMatchStreet2_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "AddressId", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchAddressId(String value) {
        return new JAXBElement<String>(_AddressMatchAddressId_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "County", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchCounty(String value) {
        return new JAXBElement<String>(_AddressMatchCounty_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "District", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchDistrict(String value) {
        return new JAXBElement<String>(_AddressMatchDistrict_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "PostCode", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchPostCode(String value) {
        return new JAXBElement<String>(_AddressMatchPostCode_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "PostTown", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchPostTown(String value) {
        return new JAXBElement<String>(_AddressMatchPostTown_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "Country", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchCountry(String value) {
        return new JAXBElement<String>(_AddressMatchCountry_QNAME, String.class, AddressMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching", name = "SubBuilding", scope = AddressMatch.class)
    public JAXBElement<String> createAddressMatchSubBuilding(String value) {
        return new JAXBElement<String>(_AddressMatchSubBuilding_QNAME, String.class, AddressMatch.class, value);
    }

}
