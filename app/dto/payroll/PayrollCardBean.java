package dto.payroll;


/**
 * Request Entity Bean for managing payroll request for card
 *
 * @author corbandalas - created 05.12.2017
 * @since 0.7.0
 */

public class PayrollCardBean {

    private String accno;
    private String title;
    private String lastName;
    private String firstName;
    private String dob;
    private String email;
    private String mobtel;
    private String addrl1;
    private String addrl2;
    private String addrl3;
    private String city;
    private String postcode;
    private String country;
    private String amount;
    private String currency;
    private String isLive;

    public PayrollCardBean() {
    }

    public PayrollCardBean(String accno, String title, String lastName, String firstName, String dob, String email, String mobtel, String addrl1, String addrl2, String addrl3, String city, String postcode, String country, String amount, String currency, String isLive) {

        this.accno = accno;
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.email = email;
        this.mobtel = mobtel;
        this.addrl1 = addrl1;
        this.addrl2 = addrl2;
        this.addrl3 = addrl3;
        this.city = city;
        this.isLive = isLive;
        this.postcode = postcode;
        this.country = country;
        this.amount = amount;
        this.currency = currency;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public String getMobtel() {
        return mobtel;
    }

    public void setMobtel(String mobtel) {
        this.mobtel = mobtel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAddrl3() {
        return addrl3;
    }

    public void setAddrl3(String addrl3) {
        this.addrl3 = addrl3;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "PropertyRequestCard{" +
                ", accno='" + accno + '\'' +
                ", title='" + title + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", mobtel='" + mobtel + '\'' +
                ", addrl1='" + addrl1 + '\'' +
                ", addrl2='" + addrl2 + '\'' +
                ", addrl3='" + addrl3 + '\'' +
                ", city='" + city + '\'' +
                ", isLive='" + isLive + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String getIsLive() {
        return isLive;
    }

    public void setIsLive(String isLive) {
        this.isLive = isLive;
    }
}
