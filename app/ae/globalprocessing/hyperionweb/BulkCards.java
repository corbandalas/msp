
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for BulkCards complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkCards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardsCreated" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CardsNotCreated" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RequestWithError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cards" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax'/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkCards", propOrder = {
    "cardsCreated",
    "cardsNotCreated",
    "actionCode",
    "requestWithError",
    "cards"
})
public class BulkCards {

    @XmlElement(name = "CardsCreated")
    protected int cardsCreated;
    @XmlElement(name = "CardsNotCreated")
    protected int cardsNotCreated;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "RequestWithError")
    protected String requestWithError;
    @XmlElement(name = "Cards")
    protected BulkCards.Cards cards;

    /**
     * Gets the value of the cardsCreated property.
     * 
     */
    public int getCardsCreated() {
        return cardsCreated;
    }

    /**
     * Sets the value of the cardsCreated property.
     * 
     */
    public void setCardsCreated(int value) {
        this.cardsCreated = value;
    }

    /**
     * Gets the value of the cardsNotCreated property.
     * 
     */
    public int getCardsNotCreated() {
        return cardsNotCreated;
    }

    /**
     * Sets the value of the cardsNotCreated property.
     * 
     */
    public void setCardsNotCreated(int value) {
        this.cardsNotCreated = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the requestWithError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestWithError() {
        return requestWithError;
    }

    /**
     * Sets the value of the requestWithError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestWithError(String value) {
        this.requestWithError = value;
    }

    /**
     * Gets the value of the cards property.
     * 
     * @return
     *     possible object is
     *     {@link BulkCards.Cards }
     *     
     */
    public BulkCards.Cards getCards() {
        return cards;
    }

    /**
     * Sets the value of the cards property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkCards.Cards }
     *     
     */
    public void setCards(BulkCards.Cards value) {
        this.cards = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax'/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Cards {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
