package dto.payroll;


/**
 * Payroll create account  request DTO object
 *
 * @author corbandalas created 11.09.2018.
 * @since 0.7.0
 */
public class PayrollCreateAccountRequest {

    private String name;
    private String currencyId;
    private String contactFirstName;
    private String contactLastName;
    private String country;
    private String phoneNumber;

    public PayrollCreateAccountRequest(String name, String currencyId) {
        this.name = name;
        this.currencyId = currencyId;
    }

    public PayrollCreateAccountRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
