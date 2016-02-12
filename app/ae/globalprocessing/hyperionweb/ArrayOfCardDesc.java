
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCardDesc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCardDesc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardDesc" type="{http://www.globalprocessing.ae/HyperionWeb}CardDesc" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCardDesc", propOrder = {
    "cardDesc"
})
public class ArrayOfCardDesc {

    @XmlElement(name = "CardDesc")
    protected List<CardDesc> cardDesc;

    /**
     * Gets the value of the cardDesc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardDesc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardDesc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardDesc }
     * 
     * 
     */
    public List<CardDesc> getCardDesc() {
        if (cardDesc == null) {
            cardDesc = new ArrayList<CardDesc>();
        }
        return this.cardDesc;
    }

}
