package dto.customer;

import model.enums.KYC;

/**
 * @author ra created 16.03.2016.
 * @since 0.1.0
 */
public interface CustomerProfile {
    String getRegistrationDate();

    void setRegistrationDate(String registrationDate);

    String getTitle();

    void setTitle(String title);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getAddress1();

    void setAddress1(String address1);

    String getAddress2();

    void setAddress2(String address2);

    String getPostcode();

    void setPostcode(String postcode);

    String getCity();

    void setCity(String city);

    String getEmail();

    void setEmail(String email);

    String getDateBirth();

    void setDateBirth(String dateBirth);

    KYC getKyc();

    void setKyc(KYC kyc);

    String getCountry_id();

    void setCountry_id(String country_id);

    String getHouseNameNumber();

    void setHouseNameNumber(String houseNameNumber);

    String getFlat();

    void setFlat(String flat);
}
