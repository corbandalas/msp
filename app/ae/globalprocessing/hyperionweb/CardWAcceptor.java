
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardWAcceptor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardWAcceptor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcceptorNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CardAcceptorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardWAcceptor", propOrder = {
    "acceptorNo",
    "cardAcceptorID"
})
public class CardWAcceptor {

    @XmlElement(name = "AcceptorNo")
    protected int acceptorNo;
    @XmlElement(name = "CardAcceptorID")
    protected String cardAcceptorID;

    /**
     * Gets the value of the acceptorNo property.
     * 
     */
    public int getAcceptorNo() {
        return acceptorNo;
    }

    /**
     * Sets the value of the acceptorNo property.
     * 
     */
    public void setAcceptorNo(int value) {
        this.acceptorNo = value;
    }

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

}
