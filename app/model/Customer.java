package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.enums.KYC;

import java.util.Date;

/**
 * Database stored entity for managing customers aka users across the project
 * Entity id - phone number in international format without leading '+'
 *
 * @author ra - created 03.02.2016
 * @since 0.1.0
 */
public class Customer extends BaseEntity<String> {

    private Date registrationDate;
    private String title;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String postcode;
    private String city;
    private String email;
    private Date dateBirth;
    private Boolean active;
    private KYC kyc;
    private String password;
    private String country_id;
    private Boolean temppassword;
    private String houseNameNumber;
    private String flat;
    private String referral;

    private String cdata = "";

    public Customer() {
    }

    public Customer(String id, Date registrationDate, String title, String firstName, String lastName, String address1, String address2, String postcode, String city, String email, Date dateBirth, Boolean active, KYC kyc, String password, String country_id) {
        this.setId(id);
        this.registrationDate = registrationDate;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
        this.dateBirth = dateBirth;
        this.active = active;
        this.kyc = kyc;
        this.password = password;
        this.country_id = country_id;
        this.temppassword = false;
    }

    public Customer(String id, Date registrationDate, String title, String firstName, String lastName, String address1, String address2, String postcode, String city, String email, Date dateBirth, Boolean active, KYC kyc, String password, String country_id, boolean temppassword, String houseNameNumber, String flat) {
        this.setId(id);
        this.registrationDate = registrationDate;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
        this.dateBirth = dateBirth;
        this.active = active;
        this.kyc = kyc;
        this.password = password;
        this.country_id = country_id;
        this.temppassword = temppassword;
        this.houseNameNumber = houseNameNumber;
        this.flat = flat;
    }

    public Customer(String id, Date registrationDate, String title, String firstName, String lastName, String address1, String address2, String postcode, String city, String email, Date dateBirth, Boolean active, KYC kyc, String password, String country_id, boolean temppassword, String houseNameNumber, String flat, String referral) {
        this.setId(id);
        this.registrationDate = registrationDate;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
        this.dateBirth = dateBirth;
        this.active = active;
        this.kyc = kyc;
        this.password = password;
        this.country_id = country_id;
        this.temppassword = temppassword;
        this.houseNameNumber = houseNameNumber;
        this.flat = flat;
        this.referral = referral;
    }

    public Customer(String id, Date registrationDate, String title, String firstName, String lastName, String address1, String address2, String postcode, String city, String email, Date dateBirth, Boolean active, KYC kyc, String password, String country_id, boolean temppassword, String houseNameNumber, String flat, String referral, String cdata) {
        this.setId(id);
        this.registrationDate = registrationDate;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
        this.dateBirth = dateBirth;
        this.active = active;
        this.kyc = kyc;
        this.password = password;
        this.country_id = country_id;
        this.temppassword = temppassword;
        this.houseNameNumber = houseNameNumber;
        this.flat = flat;
        this.referral = referral;
        this.cdata = cdata;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public KYC getKyc() {
        return kyc;
    }

    public void setKyc(KYC kyc) {
        this.kyc = kyc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public Boolean getTemppassword() {
        return temppassword;
    }

    public void setTemppassword(Boolean temppassword) {
        this.temppassword = temppassword;
    }

    @JsonIgnore
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "registrationDate=" + registrationDate +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", dateBirth=" + dateBirth +
                ", active=" + active +
                ", kyc=" + kyc +
                ", referral=" + referral +
                ", password='" + password + '\'' +
                ", country_id='" + country_id + '\'' +
                ", temppassword='" + temppassword + '\'' +
                ", houseNameNumber='" + houseNameNumber + '\'' +
                ", flat='" + flat + '\'' +
                ", cdata='" + cdata + '\'' +
                '}';
    }

    public String getHouseNameNumber() {
        return houseNameNumber;
    }

    public void setHouseNameNumber(String houseNameNumber) {
        this.houseNameNumber = houseNameNumber;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata;
    }
}
