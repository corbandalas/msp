package dto.customer;

/**
 * Customer registration request DTO object
 *
 * @author corbandalas created 16.02.2016.
 * @since 0.2.0
 */
public class CustomerRegister {

    private String phone;
    private String country;
    private String referral;

    public CustomerRegister() {
    }

    public CustomerRegister(String phone, String country) {
        this.phone = phone;
        this.country = country;
    }

    public CustomerRegister(String phone, String country, String referral) {
        this.phone = phone;
        this.country = country;
        this.referral = referral;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }
}
