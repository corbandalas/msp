
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRegime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRegime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Regime" type="{http://www.globalprocessing.ae/HyperionWeb}Regime" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRegime", propOrder = {
    "regime"
})
public class ArrayOfRegime {

    @XmlElement(name = "Regime")
    protected List<Regime> regime;

    /**
     * Gets the value of the regime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Regime }
     * 
     * 
     */
    public List<Regime> getRegime() {
        if (regime == null) {
            regime = new ArrayList<Regime>();
        }
        return this.regime;
    }

}
