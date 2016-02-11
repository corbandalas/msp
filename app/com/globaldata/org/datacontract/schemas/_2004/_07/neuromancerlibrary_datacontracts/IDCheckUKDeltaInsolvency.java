
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckUKDeltaInsolvencyTypeEnum;


/**
 * <p>Java class for IDCheckUKDeltaInsolvency complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaInsolvency">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressLabel" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaAddressLabel" minOccurs="0"/>
 *         &lt;element name="Aliases" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssetTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CaseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Court" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DebtTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Occupation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PresentationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="PreviousAddressLabel" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaAddressLabel" minOccurs="0"/>
 *         &lt;element name="ServiceOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TelephoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradingNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaInsolvencyTypeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaInsolvency", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "addressLabel",
    "aliases",
    "assetTotal",
    "caseNumber",
    "caseType",
    "court",
    "dateOfBirth",
    "debtTotal",
    "description",
    "name",
    "occupation",
    "presentationDate",
    "previousAddressLabel",
    "serviceOffice",
    "startDate",
    "status",
    "telephoneNumber",
    "tradingNames",
    "type"
})
public class IDCheckUKDeltaInsolvency {

    @XmlElementRef(name = "AddressLabel", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaAddressLabel> addressLabel;
    @XmlElementRef(name = "Aliases", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> aliases;
    @XmlElementRef(name = "AssetTotal", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assetTotal;
    @XmlElementRef(name = "CaseNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> caseNumber;
    @XmlElementRef(name = "CaseType", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> caseType;
    @XmlElementRef(name = "Court", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> court;
    @XmlElementRef(name = "DateOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateOfBirth;
    @XmlElementRef(name = "DebtTotal", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> debtTotal;
    @XmlElementRef(name = "Description", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "Occupation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> occupation;
    @XmlElementRef(name = "PresentationDate", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> presentationDate;
    @XmlElementRef(name = "PreviousAddressLabel", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaAddressLabel> previousAddressLabel;
    @XmlElementRef(name = "ServiceOffice", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceOffice;
    @XmlElementRef(name = "StartDate", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> startDate;
    @XmlElementRef(name = "Status", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "TelephoneNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telephoneNumber;
    @XmlElementRef(name = "TradingNames", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tradingNames;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaInsolvencyTypeEnum type;

    /**
     * Gets the value of the addressLabel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaAddressLabel }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaAddressLabel> getAddressLabel() {
        return addressLabel;
    }

    /**
     * Sets the value of the addressLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaAddressLabel }{@code >}
     *     
     */
    public void setAddressLabel(JAXBElement<IDCheckUKDeltaAddressLabel> value) {
        this.addressLabel = value;
    }

    /**
     * Gets the value of the aliases property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAliases() {
        return aliases;
    }

    /**
     * Sets the value of the aliases property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAliases(JAXBElement<String> value) {
        this.aliases = value;
    }

    /**
     * Gets the value of the assetTotal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssetTotal() {
        return assetTotal;
    }

    /**
     * Sets the value of the assetTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssetTotal(JAXBElement<String> value) {
        this.assetTotal = value;
    }

    /**
     * Gets the value of the caseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCaseNumber() {
        return caseNumber;
    }

    /**
     * Sets the value of the caseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCaseNumber(JAXBElement<String> value) {
        this.caseNumber = value;
    }

    /**
     * Gets the value of the caseType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCaseType() {
        return caseType;
    }

    /**
     * Sets the value of the caseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCaseType(JAXBElement<String> value) {
        this.caseType = value;
    }

    /**
     * Gets the value of the court property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCourt() {
        return court;
    }

    /**
     * Sets the value of the court property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCourt(JAXBElement<String> value) {
        this.court = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateOfBirth(JAXBElement<XMLGregorianCalendar> value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the debtTotal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDebtTotal() {
        return debtTotal;
    }

    /**
     * Sets the value of the debtTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDebtTotal(JAXBElement<String> value) {
        this.debtTotal = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * Gets the value of the occupation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOccupation() {
        return occupation;
    }

    /**
     * Sets the value of the occupation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOccupation(JAXBElement<String> value) {
        this.occupation = value;
    }

    /**
     * Gets the value of the presentationDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getPresentationDate() {
        return presentationDate;
    }

    /**
     * Sets the value of the presentationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setPresentationDate(JAXBElement<XMLGregorianCalendar> value) {
        this.presentationDate = value;
    }

    /**
     * Gets the value of the previousAddressLabel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaAddressLabel }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaAddressLabel> getPreviousAddressLabel() {
        return previousAddressLabel;
    }

    /**
     * Sets the value of the previousAddressLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaAddressLabel }{@code >}
     *     
     */
    public void setPreviousAddressLabel(JAXBElement<IDCheckUKDeltaAddressLabel> value) {
        this.previousAddressLabel = value;
    }

    /**
     * Gets the value of the serviceOffice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceOffice() {
        return serviceOffice;
    }

    /**
     * Sets the value of the serviceOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceOffice(JAXBElement<String> value) {
        this.serviceOffice = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Gets the value of the telephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the value of the telephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelephoneNumber(JAXBElement<String> value) {
        this.telephoneNumber = value;
    }

    /**
     * Gets the value of the tradingNames property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTradingNames() {
        return tradingNames;
    }

    /**
     * Sets the value of the tradingNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTradingNames(JAXBElement<String> value) {
        this.tradingNames = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaInsolvencyTypeEnum }
     *     
     */
    public IDCheckUKDeltaInsolvencyTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaInsolvencyTypeEnum }
     *     
     */
    public void setType(IDCheckUKDeltaInsolvencyTypeEnum value) {
        this.type = value;
    }

}
