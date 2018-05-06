package dto.customer;

/**
 * Request object for change pin
 * @author corbandalas created 26.03.2018.
 * @since 0.4.0
 */
public class CustomerChangeToNewPassword {

    private String phone;
    private String hashedPassword;

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
