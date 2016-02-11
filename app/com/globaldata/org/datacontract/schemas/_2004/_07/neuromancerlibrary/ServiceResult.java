
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DirectorUKCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckATBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckAddressLookupResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckCHBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckCZBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckDEAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckDEBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckITBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckNLAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckNameLookupResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckPassportMRZResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckRUBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckSKBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckUKAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckUKDeltaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckUKDrivingLicenceNumberResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckZAAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDDocumentCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.PEPDeskCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.SanctionsPlusCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.W2DataAddressLookUp007Result;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.W2DataEkycUk007Result;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.W2DataIdvcheck013Result;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.WatchlistCheckResult;


/**
 * <p>Java class for ServiceResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectorUKCheckResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKCheck}DirectorUKCheckResult" minOccurs="0"/>
 *         &lt;element name="IDCheckATBravoResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckATBravo}IDCheckATBravoResult" minOccurs="0"/>
 *         &lt;element name="IDCheckAddressLookupResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup}IDCheckAddressLookupResult" minOccurs="0"/>
 *         &lt;element name="IDCheckCHBravoResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckCHBravo}IDCheckCHBravoResult" minOccurs="0"/>
 *         &lt;element name="IDCheckCZBravoResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckCZBravo}IDCheckCZBravoResult" minOccurs="0"/>
 *         &lt;element name="IDCheckDEAlphaResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha}IDCheckDEAlphaResult" minOccurs="0"/>
 *         &lt;element name="IDCheckDEBravoResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckDEBravo}IDCheckDEBravoResult" minOccurs="0"/>
 *         &lt;element name="IDCheckITBravoResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckITBravo}IDCheckITBravoResult" minOccurs="0"/>
 *         &lt;element name="IDCheckNLAlphaResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha}IDCheckNLAlphaResult" minOccurs="0"/>
 *         &lt;element name="IDCheckNameLookupResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckNameLookup}IDCheckNameLookupResult" minOccurs="0"/>
 *         &lt;element name="IDCheckPassportMRZResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckPassportMRZ}IDCheckPassportMRZResult" minOccurs="0"/>
 *         &lt;element name="IDCheckRUBravoResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckRUBravo}IDCheckRUBravoResult" minOccurs="0"/>
 *         &lt;element name="IDCheckSKBravoResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckSKBravo}IDCheckSKBravoResult" minOccurs="0"/>
 *         &lt;element name="IDCheckUKAlphaResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}IDCheckUKAlphaResult" minOccurs="0"/>
 *         &lt;element name="IDCheckUKDeltaResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaResult" minOccurs="0"/>
 *         &lt;element name="IDCheckUKDrivingLicenceNumberResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDrivingLicenceNumber}IDCheckUKDrivingLicenceNumberResult" minOccurs="0"/>
 *         &lt;element name="IDCheckZAAlphaResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha}IDCheckZAAlphaResult" minOccurs="0"/>
 *         &lt;element name="IDDocumentCheckResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDDocumentCheck}IDDocumentCheckResult" minOccurs="0"/>
 *         &lt;element name="PEPDeskCheckResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk}PEPDeskCheckResult" minOccurs="0"/>
 *         &lt;element name="ProfileDetailsResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ProfileDetailsResult" minOccurs="0"/>
 *         &lt;element name="SISPlusCheckResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}SanctionsPlusCheckResult" minOccurs="0"/>
 *         &lt;element name="SPFPlusCheckResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}SanctionsPlusCheckResult" minOccurs="0"/>
 *         &lt;element name="W2DataAddressLookUp007Result" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataAddressLookup007}W2DataAddressLookUp007Result" minOccurs="0"/>
 *         &lt;element name="W2DataEkycUk007Result" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007}W2DataEkycUk007Result" minOccurs="0"/>
 *         &lt;element name="W2DataIdvcheck013Result" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataIdvcheck013}W2DataIdvcheck013Result" minOccurs="0"/>
 *         &lt;element name="WatchlistCheckResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}WatchlistCheckResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", propOrder = {
    "directorUKCheckResult",
    "idCheckATBravoResult",
    "idCheckAddressLookupResult",
    "idCheckCHBravoResult",
    "idCheckCZBravoResult",
    "idCheckDEAlphaResult",
    "idCheckDEBravoResult",
    "idCheckITBravoResult",
    "idCheckNLAlphaResult",
    "idCheckNameLookupResult",
    "idCheckPassportMRZResult",
    "idCheckRUBravoResult",
    "idCheckSKBravoResult",
    "idCheckUKAlphaResult",
    "idCheckUKDeltaResult",
    "idCheckUKDrivingLicenceNumberResult",
    "idCheckZAAlphaResult",
    "idDocumentCheckResult",
    "pepDeskCheckResult",
    "profileDetailsResult",
    "sisPlusCheckResult",
    "spfPlusCheckResult",
    "w2DataAddressLookUp007Result",
    "w2DataEkycUk007Result",
    "w2DataIdvcheck013Result",
    "watchlistCheckResult"
})
public class ServiceResult {

    @XmlElementRef(name = "DirectorUKCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<DirectorUKCheckResult> directorUKCheckResult;
    @XmlElementRef(name = "IDCheckATBravoResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckATBravoResult> idCheckATBravoResult;
    @XmlElementRef(name = "IDCheckAddressLookupResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckAddressLookupResult> idCheckAddressLookupResult;
    @XmlElementRef(name = "IDCheckCHBravoResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckCHBravoResult> idCheckCHBravoResult;
    @XmlElementRef(name = "IDCheckCZBravoResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckCZBravoResult> idCheckCZBravoResult;
    @XmlElementRef(name = "IDCheckDEAlphaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckDEAlphaResult> idCheckDEAlphaResult;
    @XmlElementRef(name = "IDCheckDEBravoResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckDEBravoResult> idCheckDEBravoResult;
    @XmlElementRef(name = "IDCheckITBravoResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckITBravoResult> idCheckITBravoResult;
    @XmlElementRef(name = "IDCheckNLAlphaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckNLAlphaResult> idCheckNLAlphaResult;
    @XmlElementRef(name = "IDCheckNameLookupResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckNameLookupResult> idCheckNameLookupResult;
    @XmlElementRef(name = "IDCheckPassportMRZResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckPassportMRZResult> idCheckPassportMRZResult;
    @XmlElementRef(name = "IDCheckRUBravoResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckRUBravoResult> idCheckRUBravoResult;
    @XmlElementRef(name = "IDCheckSKBravoResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckSKBravoResult> idCheckSKBravoResult;
    @XmlElementRef(name = "IDCheckUKAlphaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKAlphaResult> idCheckUKAlphaResult;
    @XmlElementRef(name = "IDCheckUKDeltaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaResult> idCheckUKDeltaResult;
    @XmlElementRef(name = "IDCheckUKDrivingLicenceNumberResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDrivingLicenceNumberResult> idCheckUKDrivingLicenceNumberResult;
    @XmlElementRef(name = "IDCheckZAAlphaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckZAAlphaResult> idCheckZAAlphaResult;
    @XmlElementRef(name = "IDDocumentCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<IDDocumentCheckResult> idDocumentCheckResult;
    @XmlElementRef(name = "PEPDeskCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<PEPDeskCheckResult> pepDeskCheckResult;
    @XmlElementRef(name = "ProfileDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<ProfileDetailsResult> profileDetailsResult;
    @XmlElementRef(name = "SISPlusCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<SanctionsPlusCheckResult> sisPlusCheckResult;
    @XmlElementRef(name = "SPFPlusCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<SanctionsPlusCheckResult> spfPlusCheckResult;
    @XmlElementRef(name = "W2DataAddressLookUp007Result", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<W2DataAddressLookUp007Result> w2DataAddressLookUp007Result;
    @XmlElementRef(name = "W2DataEkycUk007Result", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<W2DataEkycUk007Result> w2DataEkycUk007Result;
    @XmlElementRef(name = "W2DataIdvcheck013Result", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<W2DataIdvcheck013Result> w2DataIdvcheck013Result;
    @XmlElementRef(name = "WatchlistCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<WatchlistCheckResult> watchlistCheckResult;

    /**
     * Gets the value of the directorUKCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DirectorUKCheckResult }{@code >}
     *     
     */
    public JAXBElement<DirectorUKCheckResult> getDirectorUKCheckResult() {
        return directorUKCheckResult;
    }

    /**
     * Sets the value of the directorUKCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DirectorUKCheckResult }{@code >}
     *     
     */
    public void setDirectorUKCheckResult(JAXBElement<DirectorUKCheckResult> value) {
        this.directorUKCheckResult = value;
    }

    /**
     * Gets the value of the idCheckATBravoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckATBravoResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckATBravoResult> getIDCheckATBravoResult() {
        return idCheckATBravoResult;
    }

    /**
     * Sets the value of the idCheckATBravoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckATBravoResult }{@code >}
     *     
     */
    public void setIDCheckATBravoResult(JAXBElement<IDCheckATBravoResult> value) {
        this.idCheckATBravoResult = value;
    }

    /**
     * Gets the value of the idCheckAddressLookupResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckAddressLookupResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckAddressLookupResult> getIDCheckAddressLookupResult() {
        return idCheckAddressLookupResult;
    }

    /**
     * Sets the value of the idCheckAddressLookupResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckAddressLookupResult }{@code >}
     *     
     */
    public void setIDCheckAddressLookupResult(JAXBElement<IDCheckAddressLookupResult> value) {
        this.idCheckAddressLookupResult = value;
    }

    /**
     * Gets the value of the idCheckCHBravoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckCHBravoResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckCHBravoResult> getIDCheckCHBravoResult() {
        return idCheckCHBravoResult;
    }

    /**
     * Sets the value of the idCheckCHBravoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckCHBravoResult }{@code >}
     *     
     */
    public void setIDCheckCHBravoResult(JAXBElement<IDCheckCHBravoResult> value) {
        this.idCheckCHBravoResult = value;
    }

    /**
     * Gets the value of the idCheckCZBravoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckCZBravoResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckCZBravoResult> getIDCheckCZBravoResult() {
        return idCheckCZBravoResult;
    }

    /**
     * Sets the value of the idCheckCZBravoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckCZBravoResult }{@code >}
     *     
     */
    public void setIDCheckCZBravoResult(JAXBElement<IDCheckCZBravoResult> value) {
        this.idCheckCZBravoResult = value;
    }

    /**
     * Gets the value of the idCheckDEAlphaResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckDEAlphaResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckDEAlphaResult> getIDCheckDEAlphaResult() {
        return idCheckDEAlphaResult;
    }

    /**
     * Sets the value of the idCheckDEAlphaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckDEAlphaResult }{@code >}
     *     
     */
    public void setIDCheckDEAlphaResult(JAXBElement<IDCheckDEAlphaResult> value) {
        this.idCheckDEAlphaResult = value;
    }

    /**
     * Gets the value of the idCheckDEBravoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckDEBravoResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckDEBravoResult> getIDCheckDEBravoResult() {
        return idCheckDEBravoResult;
    }

    /**
     * Sets the value of the idCheckDEBravoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckDEBravoResult }{@code >}
     *     
     */
    public void setIDCheckDEBravoResult(JAXBElement<IDCheckDEBravoResult> value) {
        this.idCheckDEBravoResult = value;
    }

    /**
     * Gets the value of the idCheckITBravoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckITBravoResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckITBravoResult> getIDCheckITBravoResult() {
        return idCheckITBravoResult;
    }

    /**
     * Sets the value of the idCheckITBravoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckITBravoResult }{@code >}
     *     
     */
    public void setIDCheckITBravoResult(JAXBElement<IDCheckITBravoResult> value) {
        this.idCheckITBravoResult = value;
    }

    /**
     * Gets the value of the idCheckNLAlphaResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckNLAlphaResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckNLAlphaResult> getIDCheckNLAlphaResult() {
        return idCheckNLAlphaResult;
    }

    /**
     * Sets the value of the idCheckNLAlphaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckNLAlphaResult }{@code >}
     *     
     */
    public void setIDCheckNLAlphaResult(JAXBElement<IDCheckNLAlphaResult> value) {
        this.idCheckNLAlphaResult = value;
    }

    /**
     * Gets the value of the idCheckNameLookupResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckNameLookupResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckNameLookupResult> getIDCheckNameLookupResult() {
        return idCheckNameLookupResult;
    }

    /**
     * Sets the value of the idCheckNameLookupResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckNameLookupResult }{@code >}
     *     
     */
    public void setIDCheckNameLookupResult(JAXBElement<IDCheckNameLookupResult> value) {
        this.idCheckNameLookupResult = value;
    }

    /**
     * Gets the value of the idCheckPassportMRZResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckPassportMRZResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckPassportMRZResult> getIDCheckPassportMRZResult() {
        return idCheckPassportMRZResult;
    }

    /**
     * Sets the value of the idCheckPassportMRZResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckPassportMRZResult }{@code >}
     *     
     */
    public void setIDCheckPassportMRZResult(JAXBElement<IDCheckPassportMRZResult> value) {
        this.idCheckPassportMRZResult = value;
    }

    /**
     * Gets the value of the idCheckRUBravoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckRUBravoResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckRUBravoResult> getIDCheckRUBravoResult() {
        return idCheckRUBravoResult;
    }

    /**
     * Sets the value of the idCheckRUBravoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckRUBravoResult }{@code >}
     *     
     */
    public void setIDCheckRUBravoResult(JAXBElement<IDCheckRUBravoResult> value) {
        this.idCheckRUBravoResult = value;
    }

    /**
     * Gets the value of the idCheckSKBravoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckSKBravoResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckSKBravoResult> getIDCheckSKBravoResult() {
        return idCheckSKBravoResult;
    }

    /**
     * Sets the value of the idCheckSKBravoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckSKBravoResult }{@code >}
     *     
     */
    public void setIDCheckSKBravoResult(JAXBElement<IDCheckSKBravoResult> value) {
        this.idCheckSKBravoResult = value;
    }

    /**
     * Gets the value of the idCheckUKAlphaResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKAlphaResult> getIDCheckUKAlphaResult() {
        return idCheckUKAlphaResult;
    }

    /**
     * Sets the value of the idCheckUKAlphaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaResult }{@code >}
     *     
     */
    public void setIDCheckUKAlphaResult(JAXBElement<IDCheckUKAlphaResult> value) {
        this.idCheckUKAlphaResult = value;
    }

    /**
     * Gets the value of the idCheckUKDeltaResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaResult> getIDCheckUKDeltaResult() {
        return idCheckUKDeltaResult;
    }

    /**
     * Sets the value of the idCheckUKDeltaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaResult }{@code >}
     *     
     */
    public void setIDCheckUKDeltaResult(JAXBElement<IDCheckUKDeltaResult> value) {
        this.idCheckUKDeltaResult = value;
    }

    /**
     * Gets the value of the idCheckUKDrivingLicenceNumberResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDrivingLicenceNumberResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDrivingLicenceNumberResult> getIDCheckUKDrivingLicenceNumberResult() {
        return idCheckUKDrivingLicenceNumberResult;
    }

    /**
     * Sets the value of the idCheckUKDrivingLicenceNumberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDrivingLicenceNumberResult }{@code >}
     *     
     */
    public void setIDCheckUKDrivingLicenceNumberResult(JAXBElement<IDCheckUKDrivingLicenceNumberResult> value) {
        this.idCheckUKDrivingLicenceNumberResult = value;
    }

    /**
     * Gets the value of the idCheckZAAlphaResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckZAAlphaResult }{@code >}
     *     
     */
    public JAXBElement<IDCheckZAAlphaResult> getIDCheckZAAlphaResult() {
        return idCheckZAAlphaResult;
    }

    /**
     * Sets the value of the idCheckZAAlphaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckZAAlphaResult }{@code >}
     *     
     */
    public void setIDCheckZAAlphaResult(JAXBElement<IDCheckZAAlphaResult> value) {
        this.idCheckZAAlphaResult = value;
    }

    /**
     * Gets the value of the idDocumentCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDDocumentCheckResult }{@code >}
     *     
     */
    public JAXBElement<IDDocumentCheckResult> getIDDocumentCheckResult() {
        return idDocumentCheckResult;
    }

    /**
     * Sets the value of the idDocumentCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDDocumentCheckResult }{@code >}
     *     
     */
    public void setIDDocumentCheckResult(JAXBElement<IDDocumentCheckResult> value) {
        this.idDocumentCheckResult = value;
    }

    /**
     * Gets the value of the pepDeskCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PEPDeskCheckResult }{@code >}
     *     
     */
    public JAXBElement<PEPDeskCheckResult> getPEPDeskCheckResult() {
        return pepDeskCheckResult;
    }

    /**
     * Sets the value of the pepDeskCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PEPDeskCheckResult }{@code >}
     *     
     */
    public void setPEPDeskCheckResult(JAXBElement<PEPDeskCheckResult> value) {
        this.pepDeskCheckResult = value;
    }

    /**
     * Gets the value of the profileDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProfileDetailsResult }{@code >}
     *     
     */
    public JAXBElement<ProfileDetailsResult> getProfileDetailsResult() {
        return profileDetailsResult;
    }

    /**
     * Sets the value of the profileDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProfileDetailsResult }{@code >}
     *     
     */
    public void setProfileDetailsResult(JAXBElement<ProfileDetailsResult> value) {
        this.profileDetailsResult = value;
    }

    /**
     * Gets the value of the sisPlusCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusCheckResult }{@code >}
     *     
     */
    public JAXBElement<SanctionsPlusCheckResult> getSISPlusCheckResult() {
        return sisPlusCheckResult;
    }

    /**
     * Sets the value of the sisPlusCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusCheckResult }{@code >}
     *     
     */
    public void setSISPlusCheckResult(JAXBElement<SanctionsPlusCheckResult> value) {
        this.sisPlusCheckResult = value;
    }

    /**
     * Gets the value of the spfPlusCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusCheckResult }{@code >}
     *     
     */
    public JAXBElement<SanctionsPlusCheckResult> getSPFPlusCheckResult() {
        return spfPlusCheckResult;
    }

    /**
     * Sets the value of the spfPlusCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusCheckResult }{@code >}
     *     
     */
    public void setSPFPlusCheckResult(JAXBElement<SanctionsPlusCheckResult> value) {
        this.spfPlusCheckResult = value;
    }

    /**
     * Gets the value of the w2DataAddressLookUp007Result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link W2DataAddressLookUp007Result }{@code >}
     *     
     */
    public JAXBElement<W2DataAddressLookUp007Result> getW2DataAddressLookUp007Result() {
        return w2DataAddressLookUp007Result;
    }

    /**
     * Sets the value of the w2DataAddressLookUp007Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link W2DataAddressLookUp007Result }{@code >}
     *     
     */
    public void setW2DataAddressLookUp007Result(JAXBElement<W2DataAddressLookUp007Result> value) {
        this.w2DataAddressLookUp007Result = value;
    }

    /**
     * Gets the value of the w2DataEkycUk007Result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link W2DataEkycUk007Result }{@code >}
     *     
     */
    public JAXBElement<W2DataEkycUk007Result> getW2DataEkycUk007Result() {
        return w2DataEkycUk007Result;
    }

    /**
     * Sets the value of the w2DataEkycUk007Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link W2DataEkycUk007Result }{@code >}
     *     
     */
    public void setW2DataEkycUk007Result(JAXBElement<W2DataEkycUk007Result> value) {
        this.w2DataEkycUk007Result = value;
    }

    /**
     * Gets the value of the w2DataIdvcheck013Result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link W2DataIdvcheck013Result }{@code >}
     *     
     */
    public JAXBElement<W2DataIdvcheck013Result> getW2DataIdvcheck013Result() {
        return w2DataIdvcheck013Result;
    }

    /**
     * Sets the value of the w2DataIdvcheck013Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link W2DataIdvcheck013Result }{@code >}
     *     
     */
    public void setW2DataIdvcheck013Result(JAXBElement<W2DataIdvcheck013Result> value) {
        this.w2DataIdvcheck013Result = value;
    }

    /**
     * Gets the value of the watchlistCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WatchlistCheckResult }{@code >}
     *     
     */
    public JAXBElement<WatchlistCheckResult> getWatchlistCheckResult() {
        return watchlistCheckResult;
    }

    /**
     * Sets the value of the watchlistCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WatchlistCheckResult }{@code >}
     *     
     */
    public void setWatchlistCheckResult(JAXBElement<WatchlistCheckResult> value) {
        this.watchlistCheckResult = value;
    }

}
