
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardAcceptorModifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardAcceptorModifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardAcceptorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcceptorModifier", propOrder = {
    "cardAcceptorID",
    "action"
})
public class CardAcceptorModifier {

    @XmlElement(name = "CardAcceptorID")
    protected String cardAcceptorID;
    @XmlElement(name = "Action")
    protected int action;

    /**
     * Gets the value of the cardAcceptorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardAcceptorID() {
        return cardAcceptorID;
    }

    /**
     * Sets the value of the cardAcceptorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardAcceptorID(String value) {
        this.cardAcceptorID = value;
    }

    /**
     * Gets the value of the action property.
     * 
     */
    public int getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     */
    public void setAction(int value) {
        this.action = value;
    }

}
