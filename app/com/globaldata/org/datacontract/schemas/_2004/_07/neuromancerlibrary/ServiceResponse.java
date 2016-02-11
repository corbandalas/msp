
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}BaseResponse">
 *       &lt;sequence>
 *         &lt;element name="ClientProvidedData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ClientProvidedData" minOccurs="0"/>
 *         &lt;element name="ProcessRequestResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources}ProcessRequestResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResponse", propOrder = {
    "clientProvidedData",
    "processRequestResult"
})
public class ServiceResponse
    extends BaseResponse
{

    @XmlElementRef(name = "ClientProvidedData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ClientProvidedData> clientProvidedData;
    @XmlElementRef(name = "ProcessRequestResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ProcessRequestResult> processRequestResult;

    /**
     * Gets the value of the clientProvidedData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ClientProvidedData }{@code >}
     *     
     */
    public JAXBElement<ClientProvidedData> getClientProvidedData() {
        return clientProvidedData;
    }

    /**
     * Sets the value of the clientProvidedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ClientProvidedData }{@code >}
     *     
     */
    public void setClientProvidedData(JAXBElement<ClientProvidedData> value) {
        this.clientProvidedData = value;
    }

    /**
     * Gets the value of the processRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProcessRequestResult }{@code >}
     *     
     */
    public JAXBElement<ProcessRequestResult> getProcessRequestResult() {
        return processRequestResult;
    }

    /**
     * Sets the value of the processRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProcessRequestResult }{@code >}
     *     
     */
    public void setProcessRequestResult(JAXBElement<ProcessRequestResult> value) {
        this.processRequestResult = value;
    }

}
