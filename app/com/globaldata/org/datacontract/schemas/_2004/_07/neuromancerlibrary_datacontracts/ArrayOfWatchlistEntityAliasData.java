
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWatchlistEntityAliasData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWatchlistEntityAliasData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WatchlistEntityAliasData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}WatchlistEntityAliasData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWatchlistEntityAliasData", propOrder = {
    "watchlistEntityAliasData"
})
public class ArrayOfWatchlistEntityAliasData {

    @XmlElement(name = "WatchlistEntityAliasData", nillable = true)
    protected List<WatchlistEntityAliasData> watchlistEntityAliasData;

    /**
     * Gets the value of the watchlistEntityAliasData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the watchlistEntityAliasData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWatchlistEntityAliasData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WatchlistEntityAliasData }
     * 
     * 
     */
    public List<WatchlistEntityAliasData> getWatchlistEntityAliasData() {
        if (watchlistEntityAliasData == null) {
            watchlistEntityAliasData = new ArrayList<WatchlistEntityAliasData>();
        }
        return this.watchlistEntityAliasData;
    }

}
