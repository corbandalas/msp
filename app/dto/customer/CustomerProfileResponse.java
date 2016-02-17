package dto.customer;

import dto.BaseAPIResponse;
import model.Customer;
import model.enums.KYC;
import org.springframework.beans.BeanUtils;
import util.DateUtil;

/**
 * API customer profile response
 * @author ra created 17.02.2016.
 * @since 0.2.0
 */
public class CustomerProfileResponse extends BaseAPIResponse {

    private String registrationDate;
    private String title;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String postcode;
    private String city;
    private String email;
    private String dateBirth;
    private KYC kyc;
    private String country_id;

    public CustomerProfileResponse(String text, String code, Customer customer) {
        super(text, code);
        BeanUtils.copyProperties(customer, this);
        registrationDate = DateUtil.format(customer.getRegistrationDate(), "yyyy-MM-dd");
        dateBirth = DateUtil.format(customer.getDateBirth(), "yyyy-MM-dd");
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public KYC getKyc() {
        return kyc;
    }

    public void setKyc(KYC kyc) {
        this.kyc = kyc;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
