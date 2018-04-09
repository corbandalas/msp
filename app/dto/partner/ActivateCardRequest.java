package dto.partner;

/**
 * Activate card request DTO object
 *
 * @author corbandalas created 20.09.2017.
 * @since 0.6.0
 */
public class ActivateCardRequest {

    private String token;

    private String cvv;

    private String cardNumber;

    private String lastName;

    private String firstName;

    private String addrl1;

    private String addrl2;

    private String city;

    private String postCode;

    private String country;

    private String dob;

    public ActivateCardRequest() {
    }

    public ActivateCardRequest(String token, String cvv, String cardNumber, String lastName, String firstName, String addrl1, String addrl2, String city, String postCode, String country, String dob) {
        this.token = token;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.addrl1 = addrl1;
        this.addrl2 = addrl2;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.dob = dob;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddrl1() {
        return addrl1;
    }

    public void setAddrl1(String addrl1) {
        this.addrl1 = addrl1;
    }

    public String getAddrl2() {
        return addrl2;
    }

    public void setAddrl2(String addrl2) {
        this.addrl2 = addrl2;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}


