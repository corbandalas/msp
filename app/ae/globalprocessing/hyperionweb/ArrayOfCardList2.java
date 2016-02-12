
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCardList2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCardList2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardList2" type="{http://www.globalprocessing.ae/HyperionWeb}CardList2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCardList2", propOrder = {
    "cardList2"
})
public class ArrayOfCardList2 {

    @XmlElement(name = "CardList2")
    protected List<CardList2> cardList2;

    /**
     * Gets the value of the cardList2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardList2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardList2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardList2 }
     * 
     * 
     */
    public List<CardList2> getCardList2() {
        if (cardList2 == null) {
            cardList2 = new ArrayList<CardList2>();
        }
        return this.cardList2;
    }

}
