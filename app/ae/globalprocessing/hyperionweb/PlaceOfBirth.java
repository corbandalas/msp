
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceOfBirth complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlaceOfBirth">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaceOfBirth", propOrder = {
    "pob"
})
public class PlaceOfBirth {

    @XmlElement(name = "POB")
    protected String pob;

    /**
     * Gets the value of the pob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOB() {
        return pob;
    }

    /**
     * Sets the value of the pob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOB(String value) {
        this.pob = value;
    }

}
