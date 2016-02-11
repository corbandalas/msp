
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckAddressLookupAddressTypeEnum;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckAddressLookupDataLevelEnum;


/**
 * <p>Java class for IDCheckAddressLookupMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckAddressLookupMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdminAreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdminAreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuildingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuildingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckAddressType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckAddressLookupAddressTypeEnum" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryIso2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryIso3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryIsoNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataLevel" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckAddressLookupDataLevelEnum" minOccurs="0"/>
 *         &lt;element name="Department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="District" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DomesticId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDCheckAddressLookupAddressCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LanguageAlternatives" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Neighbourhood" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POBoxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProvinceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondaryStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SortingNumber1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SortingNumber2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubBuilding" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckAddressLookupMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", propOrder = {
    "adminAreaCode",
    "adminAreaName",
    "barcode",
    "block",
    "buildingName",
    "buildingNumber",
    "checkAddressType",
    "city",
    "company",
    "countryIso2",
    "countryIso3",
    "countryIsoNumber",
    "countryName",
    "dataLevel",
    "department",
    "district",
    "domesticId",
    "idCheckAddressLookupAddressCode",
    "label",
    "language",
    "languageAlternatives",
    "line1",
    "line2",
    "line3",
    "line4",
    "line5",
    "neighbourhood",
    "poBoxNumber",
    "postalCode",
    "province",
    "provinceCode",
    "provinceName",
    "secondaryStreet",
    "sortingNumber1",
    "sortingNumber2",
    "street",
    "subBuilding",
    "text"
})
public class IDCheckAddressLookupMatch {

    @XmlElementRef(name = "AdminAreaCode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminAreaCode;
    @XmlElementRef(name = "AdminAreaName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminAreaName;
    @XmlElementRef(name = "Barcode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> barcode;
    @XmlElementRef(name = "Block", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> block;
    @XmlElementRef(name = "BuildingName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buildingName;
    @XmlElementRef(name = "BuildingNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buildingNumber;
    @XmlElement(name = "CheckAddressType")
    @XmlSchemaType(name = "string")
    protected IDCheckAddressLookupAddressTypeEnum checkAddressType;
    @XmlElementRef(name = "City", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> city;
    @XmlElementRef(name = "Company", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> company;
    @XmlElementRef(name = "CountryIso2", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> countryIso2;
    @XmlElementRef(name = "CountryIso3", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> countryIso3;
    @XmlElementRef(name = "CountryIsoNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> countryIsoNumber;
    @XmlElementRef(name = "CountryName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> countryName;
    @XmlElement(name = "DataLevel")
    @XmlSchemaType(name = "string")
    protected IDCheckAddressLookupDataLevelEnum dataLevel;
    @XmlElementRef(name = "Department", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> department;
    @XmlElementRef(name = "District", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> district;
    @XmlElementRef(name = "DomesticId", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> domesticId;
    @XmlElementRef(name = "IDCheckAddressLookupAddressCode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idCheckAddressLookupAddressCode;
    @XmlElementRef(name = "Label", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> label;
    @XmlElementRef(name = "Language", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> language;
    @XmlElementRef(name = "LanguageAlternatives", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> languageAlternatives;
    @XmlElementRef(name = "Line1", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> line1;
    @XmlElementRef(name = "Line2", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> line2;
    @XmlElementRef(name = "Line3", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> line3;
    @XmlElementRef(name = "Line4", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> line4;
    @XmlElementRef(name = "Line5", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> line5;
    @XmlElementRef(name = "Neighbourhood", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> neighbourhood;
    @XmlElementRef(name = "POBoxNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> poBoxNumber;
    @XmlElementRef(name = "PostalCode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> postalCode;
    @XmlElementRef(name = "Province", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> province;
    @XmlElementRef(name = "ProvinceCode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> provinceCode;
    @XmlElementRef(name = "ProvinceName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> provinceName;
    @XmlElementRef(name = "SecondaryStreet", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secondaryStreet;
    @XmlElementRef(name = "SortingNumber1", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sortingNumber1;
    @XmlElementRef(name = "SortingNumber2", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sortingNumber2;
    @XmlElementRef(name = "Street", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> street;
    @XmlElementRef(name = "SubBuilding", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subBuilding;
    @XmlElementRef(name = "Text", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<String> text;

    /**
     * Gets the value of the adminAreaCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminAreaCode() {
        return adminAreaCode;
    }

    /**
     * Sets the value of the adminAreaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminAreaCode(JAXBElement<String> value) {
        this.adminAreaCode = value;
    }

    /**
     * Gets the value of the adminAreaName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminAreaName() {
        return adminAreaName;
    }

    /**
     * Sets the value of the adminAreaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminAreaName(JAXBElement<String> value) {
        this.adminAreaName = value;
    }

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBarcode() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBarcode(JAXBElement<String> value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the block property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBlock() {
        return block;
    }

    /**
     * Sets the value of the block property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBlock(JAXBElement<String> value) {
        this.block = value;
    }

    /**
     * Gets the value of the buildingName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuildingName() {
        return buildingName;
    }

    /**
     * Sets the value of the buildingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuildingName(JAXBElement<String> value) {
        this.buildingName = value;
    }

    /**
     * Gets the value of the buildingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Sets the value of the buildingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuildingNumber(JAXBElement<String> value) {
        this.buildingNumber = value;
    }

    /**
     * Gets the value of the checkAddressType property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckAddressLookupAddressTypeEnum }
     *     
     */
    public IDCheckAddressLookupAddressTypeEnum getCheckAddressType() {
        return checkAddressType;
    }

    /**
     * Sets the value of the checkAddressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckAddressLookupAddressTypeEnum }
     *     
     */
    public void setCheckAddressType(IDCheckAddressLookupAddressTypeEnum value) {
        this.checkAddressType = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCity(JAXBElement<String> value) {
        this.city = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompany(JAXBElement<String> value) {
        this.company = value;
    }

    /**
     * Gets the value of the countryIso2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountryIso2() {
        return countryIso2;
    }

    /**
     * Sets the value of the countryIso2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountryIso2(JAXBElement<String> value) {
        this.countryIso2 = value;
    }

    /**
     * Gets the value of the countryIso3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountryIso3() {
        return countryIso3;
    }

    /**
     * Sets the value of the countryIso3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountryIso3(JAXBElement<String> value) {
        this.countryIso3 = value;
    }

    /**
     * Gets the value of the countryIsoNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountryIsoNumber() {
        return countryIsoNumber;
    }

    /**
     * Sets the value of the countryIsoNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountryIsoNumber(JAXBElement<String> value) {
        this.countryIsoNumber = value;
    }

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountryName(JAXBElement<String> value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the dataLevel property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckAddressLookupDataLevelEnum }
     *     
     */
    public IDCheckAddressLookupDataLevelEnum getDataLevel() {
        return dataLevel;
    }

    /**
     * Sets the value of the dataLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckAddressLookupDataLevelEnum }
     *     
     */
    public void setDataLevel(IDCheckAddressLookupDataLevelEnum value) {
        this.dataLevel = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDepartment(JAXBElement<String> value) {
        this.department = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDistrict(JAXBElement<String> value) {
        this.district = value;
    }

    /**
     * Gets the value of the domesticId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDomesticId() {
        return domesticId;
    }

    /**
     * Sets the value of the domesticId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDomesticId(JAXBElement<String> value) {
        this.domesticId = value;
    }

    /**
     * Gets the value of the idCheckAddressLookupAddressCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIDCheckAddressLookupAddressCode() {
        return idCheckAddressLookupAddressCode;
    }

    /**
     * Sets the value of the idCheckAddressLookupAddressCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDCheckAddressLookupAddressCode(JAXBElement<String> value) {
        this.idCheckAddressLookupAddressCode = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLabel(JAXBElement<String> value) {
        this.label = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLanguage(JAXBElement<String> value) {
        this.language = value;
    }

    /**
     * Gets the value of the languageAlternatives property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLanguageAlternatives() {
        return languageAlternatives;
    }

    /**
     * Sets the value of the languageAlternatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLanguageAlternatives(JAXBElement<String> value) {
        this.languageAlternatives = value;
    }

    /**
     * Gets the value of the line1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLine1() {
        return line1;
    }

    /**
     * Sets the value of the line1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLine1(JAXBElement<String> value) {
        this.line1 = value;
    }

    /**
     * Gets the value of the line2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLine2() {
        return line2;
    }

    /**
     * Sets the value of the line2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLine2(JAXBElement<String> value) {
        this.line2 = value;
    }

    /**
     * Gets the value of the line3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLine3() {
        return line3;
    }

    /**
     * Sets the value of the line3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLine3(JAXBElement<String> value) {
        this.line3 = value;
    }

    /**
     * Gets the value of the line4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLine4() {
        return line4;
    }

    /**
     * Sets the value of the line4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLine4(JAXBElement<String> value) {
        this.line4 = value;
    }

    /**
     * Gets the value of the line5 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLine5() {
        return line5;
    }

    /**
     * Sets the value of the line5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLine5(JAXBElement<String> value) {
        this.line5 = value;
    }

    /**
     * Gets the value of the neighbourhood property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNeighbourhood() {
        return neighbourhood;
    }

    /**
     * Sets the value of the neighbourhood property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNeighbourhood(JAXBElement<String> value) {
        this.neighbourhood = value;
    }

    /**
     * Gets the value of the poBoxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPOBoxNumber() {
        return poBoxNumber;
    }

    /**
     * Sets the value of the poBoxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPOBoxNumber(JAXBElement<String> value) {
        this.poBoxNumber = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPostalCode(JAXBElement<String> value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProvince(JAXBElement<String> value) {
        this.province = value;
    }

    /**
     * Gets the value of the provinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProvinceCode() {
        return provinceCode;
    }

    /**
     * Sets the value of the provinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProvinceCode(JAXBElement<String> value) {
        this.provinceCode = value;
    }

    /**
     * Gets the value of the provinceName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProvinceName() {
        return provinceName;
    }

    /**
     * Sets the value of the provinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProvinceName(JAXBElement<String> value) {
        this.provinceName = value;
    }

    /**
     * Gets the value of the secondaryStreet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecondaryStreet() {
        return secondaryStreet;
    }

    /**
     * Sets the value of the secondaryStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecondaryStreet(JAXBElement<String> value) {
        this.secondaryStreet = value;
    }

    /**
     * Gets the value of the sortingNumber1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSortingNumber1() {
        return sortingNumber1;
    }

    /**
     * Sets the value of the sortingNumber1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSortingNumber1(JAXBElement<String> value) {
        this.sortingNumber1 = value;
    }

    /**
     * Gets the value of the sortingNumber2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSortingNumber2() {
        return sortingNumber2;
    }

    /**
     * Sets the value of the sortingNumber2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSortingNumber2(JAXBElement<String> value) {
        this.sortingNumber2 = value;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStreet(JAXBElement<String> value) {
        this.street = value;
    }

    /**
     * Gets the value of the subBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubBuilding() {
        return subBuilding;
    }

    /**
     * Sets the value of the subBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubBuilding(JAXBElement<String> value) {
        this.subBuilding = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setText(JAXBElement<String> value) {
        this.text = value;
    }

}
