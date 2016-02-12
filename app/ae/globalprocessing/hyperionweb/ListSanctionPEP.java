
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListSanctionPEP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListSanctionPEP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ListedOn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateOfBirths" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfDateOfBirth" minOccurs="0"/>
 *         &lt;element name="PlaceOfBirths" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfPlaceOfBirth" minOccurs="0"/>
 *         &lt;element name="Nationalities" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfNationality" minOccurs="0"/>
 *         &lt;element name="Passports" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfPassport" minOccurs="0"/>
 *         &lt;element name="NationalIdentificationNumbers" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfNationalIdentificationNumber" minOccurs="0"/>
 *         &lt;element name="Positions" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfPosition" minOccurs="0"/>
 *         &lt;element name="Addresses" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfAddress" minOccurs="0"/>
 *         &lt;element name="Aliases" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfAka" minOccurs="0"/>
 *         &lt;element name="Regimes" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfRegime" minOccurs="0"/>
 *         &lt;element name="OtherInfomations" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfOtherInfomation" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSanctionPEP", propOrder = {
    "wsid",
    "issCode",
    "id",
    "source",
    "listedOn",
    "name",
    "title",
    "dateOfBirths",
    "placeOfBirths",
    "nationalities",
    "passports",
    "nationalIdentificationNumbers",
    "positions",
    "addresses",
    "aliases",
    "regimes",
    "otherInfomations",
    "actionCode"
})
public class ListSanctionPEP {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "Source")
    protected String source;
    @XmlElement(name = "ListedOn")
    protected String listedOn;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "DateOfBirths")
    protected ArrayOfDateOfBirth dateOfBirths;
    @XmlElement(name = "PlaceOfBirths")
    protected ArrayOfPlaceOfBirth placeOfBirths;
    @XmlElement(name = "Nationalities")
    protected ArrayOfNationality nationalities;
    @XmlElement(name = "Passports")
    protected ArrayOfPassport passports;
    @XmlElement(name = "NationalIdentificationNumbers")
    protected ArrayOfNationalIdentificationNumber nationalIdentificationNumbers;
    @XmlElement(name = "Positions")
    protected ArrayOfPosition positions;
    @XmlElement(name = "Addresses")
    protected ArrayOfAddress addresses;
    @XmlElement(name = "Aliases")
    protected ArrayOfAka aliases;
    @XmlElement(name = "Regimes")
    protected ArrayOfRegime regimes;
    @XmlElement(name = "OtherInfomations")
    protected ArrayOfOtherInfomation otherInfomations;
    @XmlElement(name = "ActionCode")
    protected String actionCode;

    /**
     * Gets the value of the wsid property.
     * 
     */
    public long getWSID() {
        return wsid;
    }

    /**
     * Sets the value of the wsid property.
     * 
     */
    public void setWSID(long value) {
        this.wsid = value;
    }

    /**
     * Gets the value of the issCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssCode() {
        return issCode;
    }

    /**
     * Sets the value of the issCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssCode(String value) {
        this.issCode = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the listedOn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListedOn() {
        return listedOn;
    }

    /**
     * Sets the value of the listedOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListedOn(String value) {
        this.listedOn = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the dateOfBirths property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDateOfBirth }
     *     
     */
    public ArrayOfDateOfBirth getDateOfBirths() {
        return dateOfBirths;
    }

    /**
     * Sets the value of the dateOfBirths property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDateOfBirth }
     *     
     */
    public void setDateOfBirths(ArrayOfDateOfBirth value) {
        this.dateOfBirths = value;
    }

    /**
     * Gets the value of the placeOfBirths property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPlaceOfBirth }
     *     
     */
    public ArrayOfPlaceOfBirth getPlaceOfBirths() {
        return placeOfBirths;
    }

    /**
     * Sets the value of the placeOfBirths property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPlaceOfBirth }
     *     
     */
    public void setPlaceOfBirths(ArrayOfPlaceOfBirth value) {
        this.placeOfBirths = value;
    }

    /**
     * Gets the value of the nationalities property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNationality }
     *     
     */
    public ArrayOfNationality getNationalities() {
        return nationalities;
    }

    /**
     * Sets the value of the nationalities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNationality }
     *     
     */
    public void setNationalities(ArrayOfNationality value) {
        this.nationalities = value;
    }

    /**
     * Gets the value of the passports property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPassport }
     *     
     */
    public ArrayOfPassport getPassports() {
        return passports;
    }

    /**
     * Sets the value of the passports property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPassport }
     *     
     */
    public void setPassports(ArrayOfPassport value) {
        this.passports = value;
    }

    /**
     * Gets the value of the nationalIdentificationNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNationalIdentificationNumber }
     *     
     */
    public ArrayOfNationalIdentificationNumber getNationalIdentificationNumbers() {
        return nationalIdentificationNumbers;
    }

    /**
     * Sets the value of the nationalIdentificationNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNationalIdentificationNumber }
     *     
     */
    public void setNationalIdentificationNumbers(ArrayOfNationalIdentificationNumber value) {
        this.nationalIdentificationNumbers = value;
    }

    /**
     * Gets the value of the positions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPosition }
     *     
     */
    public ArrayOfPosition getPositions() {
        return positions;
    }

    /**
     * Sets the value of the positions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPosition }
     *     
     */
    public void setPositions(ArrayOfPosition value) {
        this.positions = value;
    }

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAddress }
     *     
     */
    public ArrayOfAddress getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAddress }
     *     
     */
    public void setAddresses(ArrayOfAddress value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the aliases property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAka }
     *     
     */
    public ArrayOfAka getAliases() {
        return aliases;
    }

    /**
     * Sets the value of the aliases property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAka }
     *     
     */
    public void setAliases(ArrayOfAka value) {
        this.aliases = value;
    }

    /**
     * Gets the value of the regimes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRegime }
     *     
     */
    public ArrayOfRegime getRegimes() {
        return regimes;
    }

    /**
     * Sets the value of the regimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRegime }
     *     
     */
    public void setRegimes(ArrayOfRegime value) {
        this.regimes = value;
    }

    /**
     * Gets the value of the otherInfomations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOtherInfomation }
     *     
     */
    public ArrayOfOtherInfomation getOtherInfomations() {
        return otherInfomations;
    }

    /**
     * Sets the value of the otherInfomations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOtherInfomation }
     *     
     */
    public void setOtherInfomations(ArrayOfOtherInfomation value) {
        this.otherInfomations = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

}
