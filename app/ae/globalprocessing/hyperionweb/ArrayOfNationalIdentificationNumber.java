
package ae.globalprocessing.hyperionweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNationalIdentificationNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNationalIdentificationNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NationalIdentificationNumber" type="{http://www.globalprocessing.ae/HyperionWeb}NationalIdentificationNumber" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNationalIdentificationNumber", propOrder = {
    "nationalIdentificationNumber"
})
public class ArrayOfNationalIdentificationNumber {

    @XmlElement(name = "NationalIdentificationNumber")
    protected List<NationalIdentificationNumber> nationalIdentificationNumber;

    /**
     * Gets the value of the nationalIdentificationNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nationalIdentificationNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNationalIdentificationNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NationalIdentificationNumber }
     * 
     * 
     */
    public List<NationalIdentificationNumber> getNationalIdentificationNumber() {
        if (nationalIdentificationNumber == null) {
            nationalIdentificationNumber = new ArrayList<NationalIdentificationNumber>();
        }
        return this.nationalIdentificationNumber;
    }

}
