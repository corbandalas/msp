
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLimitInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLimitInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LimitInformation" type="{http://www.globalprocessing.ae/HyperionWeb}LimitInformation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLimitInformation", propOrder = {
    "limitInformation"
})
public class ArrayOfLimitInformation {

    @XmlElement(name = "LimitInformation")
    protected List<LimitInformation> limitInformation;

    /**
     * Gets the value of the limitInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the limitInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLimitInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LimitInformation }
     * 
     * 
     */
    public List<LimitInformation> getLimitInformation() {
        if (limitInformation == null) {
            limitInformation = new ArrayList<LimitInformation>();
        }
        return this.limitInformation;
    }

}
