package dto.customer;

import model.Customer;
import model.enums.KYC;
import org.springframework.beans.BeanUtils;
import util.DateUtil;

import java.text.ParseException;

/**
 * @author ra created 16.03.2016.
 * @since 0.1.0
 */
public class CustomerProfileRequest implements CustomerProfile {
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

    @Override
    public String getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate=registrationDate;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title=title;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    @Override
    public String getAddress1() {
        return address1;
    }

    @Override
    public void setAddress1(String address1) {
        this.address1=address1;
    }

    @Override
    public String getAddress2() {
        return address2;
    }

    @Override
    public void setAddress2(String address2) {
        this.address2=address2;
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public void setPostcode(String postcode) {
        this.postcode=postcode;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city=city;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email=email;
    }

    @Override
    public String getDateBirth() {
        return dateBirth;
    }

    @Override
    public void setDateBirth(String dateBirth) {
        this.dateBirth=dateBirth;
    }

    @Override
    public KYC getKyc() {
        return kyc;
    }

    @Override
    public void setKyc(KYC kyc) {
        this.kyc=kyc;
    }

    @Override
    public String getCountry_id() {
        return country_id;
    }

    @Override
    public void setCountry_id(String country_id) {
        this.country_id=country_id;
    }

    public void copyToCustomer(Customer customer) throws ParseException {
        BeanUtils.copyProperties(this,customer);
        customer.setRegistrationDate(DateUtil.parse(registrationDate,"yyyy-MM-dd"));
        customer.setDateBirth(DateUtil.parse(dateBirth,"yyyy-MM-dd"));
    }
}
