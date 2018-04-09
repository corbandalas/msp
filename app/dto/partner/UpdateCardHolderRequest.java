package dto.partner;

/**
 * Update card holder request DTO object
 *
 * @author corbandalas created 09.04.2018.
 * @since 0.6.0
 */

public class UpdateCardHolderRequest {

    private String token;

    private String firstName;

    private String lastName;

    private String title;

    private String addressl1;

    private String addressl2;

    private String addressl3;

    private String city;

    private String postCode;

    private String phone;

    private String email;

    private String country;

    public UpdateCardHolderRequest(String token, String firstName, String lastName, String title, String addressl1, String addressl2, String addressl3, String city, String postCode, String phone, String email, String country) {
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.addressl1 = addressl1;
        this.addressl2 = addressl2;
        this.addressl3 = addressl3;
        this.city = city;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
        this.country = country;
    }

    public UpdateCardHolderRequest() {
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressl1() {
        return addressl1;
    }

    public void setAddressl1(String addressl1) {
        this.addressl1 = addressl1;
    }

    public String getAddressl2() {
        return addressl2;
    }

    public void setAddressl2(String addressl2) {
        this.addressl2 = addressl2;
    }

    public String getAddressl3() {
        return addressl3;
    }

    public void setAddressl3(String addressl3) {
        this.addressl3 = addressl3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}


