
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCardAccepterList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCardAccepterList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardAccepterList" type="{http://www.globalprocessing.ae/HyperionWeb}CardAccepterList" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCardAccepterList", propOrder = {
    "cardAccepterList"
})
public class ArrayOfCardAccepterList {

    @XmlElement(name = "CardAccepterList")
    protected List<CardAccepterList> cardAccepterList;

    /**
     * Gets the value of the cardAccepterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardAccepterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardAccepterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardAccepterList }
     * 
     * 
     */
    public List<CardAccepterList> getCardAccepterList() {
        if (cardAccepterList == null) {
            cardAccepterList = new ArrayList<CardAccepterList>();
        }
        return this.cardAccepterList;
    }

}
