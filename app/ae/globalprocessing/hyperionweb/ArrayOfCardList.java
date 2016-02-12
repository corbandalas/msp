
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCardList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCardList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardList" type="{http://www.globalprocessing.ae/HyperionWeb}CardList" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCardList", propOrder = {
    "cardList"
})
public class ArrayOfCardList {

    @XmlElement(name = "CardList")
    protected List<CardList> cardList;

    /**
     * Gets the value of the cardList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardList }
     * 
     * 
     */
    public List<CardList> getCardList() {
        if (cardList == null) {
            cardList = new ArrayList<CardList>();
        }
        return this.cardList;
    }

}
