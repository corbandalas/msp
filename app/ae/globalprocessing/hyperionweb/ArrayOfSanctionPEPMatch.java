
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSanctionPEPMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSanctionPEPMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SanctionPEPMatch" type="{http://www.globalprocessing.ae/HyperionWeb}SanctionPEPMatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSanctionPEPMatch", propOrder = {
    "sanctionPEPMatch"
})
public class ArrayOfSanctionPEPMatch {

    @XmlElement(name = "SanctionPEPMatch")
    protected List<SanctionPEPMatch> sanctionPEPMatch;

    /**
     * Gets the value of the sanctionPEPMatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sanctionPEPMatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSanctionPEPMatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SanctionPEPMatch }
     * 
     * 
     */
    public List<SanctionPEPMatch> getSanctionPEPMatch() {
        if (sanctionPEPMatch == null) {
            sanctionPEPMatch = new ArrayList<SanctionPEPMatch>();
        }
        return this.sanctionPEPMatch;
    }

}
