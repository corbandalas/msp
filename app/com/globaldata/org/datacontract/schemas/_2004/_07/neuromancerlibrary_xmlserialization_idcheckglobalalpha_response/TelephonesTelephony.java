
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TelephonesTelephony complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelephonesTelephony">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TelephoneList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony}ArrayOfTelephoneTelephony" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelephonesTelephony", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", propOrder = {
    "telephoneList"
})
public class TelephonesTelephony {

    @XmlElementRef(name = "TelephoneList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfTelephoneTelephony> telephoneList;

    /**
     * Gets the value of the telephoneList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTelephoneTelephony }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTelephoneTelephony> getTelephoneList() {
        return telephoneList;
    }

    /**
     * Sets the value of the telephoneList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTelephoneTelephony }{@code >}
     *     
     */
    public void setTelephoneList(JAXBElement<ArrayOfTelephoneTelephony> value) {
        this.telephoneList = value;
    }

}
