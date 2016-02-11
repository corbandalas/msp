
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TelephonesDirectors complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelephonesDirectors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TelephoneList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors}ArrayOfTelephoneDirectors" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelephonesDirectors", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", propOrder = {
    "telephoneList"
})
public class TelephonesDirectors {

    @XmlElementRef(name = "TelephoneList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfTelephoneDirectors> telephoneList;

    /**
     * Gets the value of the telephoneList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTelephoneDirectors }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTelephoneDirectors> getTelephoneList() {
        return telephoneList;
    }

    /**
     * Sets the value of the telephoneList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTelephoneDirectors }{@code >}
     *     
     */
    public void setTelephoneList(JAXBElement<ArrayOfTelephoneDirectors> value) {
        this.telephoneList = value;
    }

}
