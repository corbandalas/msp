
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Regime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Regime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Regiment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Regime", propOrder = {
    "regiment"
})
public class Regime {

    @XmlElement(name = "Regiment")
    protected String regiment;

    /**
     * Gets the value of the regiment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegiment() {
        return regiment;
    }

    /**
     * Sets the value of the regiment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegiment(String value) {
        this.regiment = value;
    }

}
