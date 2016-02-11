
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IssuesBlockResponseElementModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IssuesBlockResponseElementModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Issues" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}ArrayOfIssueResponseElementModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IssuesBlockResponseElementModel", propOrder = {
    "issues"
})
public class IssuesBlockResponseElementModel {

    @XmlElementRef(name = "Issues", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIssueResponseElementModel> issues;

    /**
     * Gets the value of the issues property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIssueResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIssueResponseElementModel> getIssues() {
        return issues;
    }

    /**
     * Sets the value of the issues property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIssueResponseElementModel }{@code >}
     *     
     */
    public void setIssues(JAXBElement<ArrayOfIssueResponseElementModel> value) {
        this.issues = value;
    }

}
