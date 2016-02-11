
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckUKDeltaCompanyDirectorMatchTypeEnum;


/**
 * <p>Java class for IDCheckUKDeltaCompanyDirector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaCompanyDirector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyAppointments" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaCompanyAppointment" minOccurs="0"/>
 *         &lt;element name="CompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DateAppointed" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MatchType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaCompanyDirectorMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="RegisteredOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaCompanyDirector", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "companyAppointments",
    "companyName",
    "companyRegistrationNumber",
    "dateAppointed",
    "matchType",
    "registeredOffice"
})
public class IDCheckUKDeltaCompanyDirector {

    @XmlElementRef(name = "CompanyAppointments", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaCompanyAppointment> companyAppointments;
    @XmlElementRef(name = "CompanyName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> companyName;
    @XmlElement(name = "CompanyRegistrationNumber")
    protected Integer companyRegistrationNumber;
    @XmlElementRef(name = "DateAppointed", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateAppointed;
    @XmlElement(name = "MatchType")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaCompanyDirectorMatchTypeEnum matchType;
    @XmlElementRef(name = "RegisteredOffice", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> registeredOffice;

    /**
     * Gets the value of the companyAppointments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaCompanyAppointment }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaCompanyAppointment> getCompanyAppointments() {
        return companyAppointments;
    }

    /**
     * Sets the value of the companyAppointments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaCompanyAppointment }{@code >}
     *     
     */
    public void setCompanyAppointments(JAXBElement<ArrayOfIDCheckUKDeltaCompanyAppointment> value) {
        this.companyAppointments = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyName(JAXBElement<String> value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the companyRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    /**
     * Sets the value of the companyRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCompanyRegistrationNumber(Integer value) {
        this.companyRegistrationNumber = value;
    }

    /**
     * Gets the value of the dateAppointed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateAppointed() {
        return dateAppointed;
    }

    /**
     * Sets the value of the dateAppointed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateAppointed(JAXBElement<XMLGregorianCalendar> value) {
        this.dateAppointed = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaCompanyDirectorMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaCompanyDirectorMatchTypeEnum getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaCompanyDirectorMatchTypeEnum }
     *     
     */
    public void setMatchType(IDCheckUKDeltaCompanyDirectorMatchTypeEnum value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the registeredOffice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegisteredOffice() {
        return registeredOffice;
    }

    /**
     * Sets the value of the registeredOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegisteredOffice(JAXBElement<String> value) {
        this.registeredOffice = value;
    }

}
