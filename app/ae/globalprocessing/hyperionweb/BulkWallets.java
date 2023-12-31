
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for BulkWallets complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkWallets">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WalletCreated" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="WalletNotCreated" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RequestWithError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Wallets" minOccurs="0">
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
@XmlType(name = "BulkWallets", propOrder = {
    "walletCreated",
    "walletNotCreated",
    "actionCode",
    "requestWithError",
    "wallets"
})
public class BulkWallets {

    @XmlElement(name = "WalletCreated")
    protected int walletCreated;
    @XmlElement(name = "WalletNotCreated")
    protected int walletNotCreated;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "RequestWithError")
    protected String requestWithError;
    @XmlElement(name = "Wallets")
    protected BulkWallets.Wallets wallets;

    /**
     * Gets the value of the walletCreated property.
     * 
     */
    public int getWalletCreated() {
        return walletCreated;
    }

    /**
     * Sets the value of the walletCreated property.
     * 
     */
    public void setWalletCreated(int value) {
        this.walletCreated = value;
    }

    /**
     * Gets the value of the walletNotCreated property.
     * 
     */
    public int getWalletNotCreated() {
        return walletNotCreated;
    }

    /**
     * Sets the value of the walletNotCreated property.
     * 
     */
    public void setWalletNotCreated(int value) {
        this.walletNotCreated = value;
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
     * Gets the value of the wallets property.
     * 
     * @return
     *     possible object is
     *     {@link BulkWallets.Wallets }
     *     
     */
    public BulkWallets.Wallets getWallets() {
        return wallets;
    }

    /**
     * Sets the value of the wallets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkWallets.Wallets }
     *     
     */
    public void setWallets(BulkWallets.Wallets value) {
        this.wallets = value;
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
    public static class Wallets {

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
