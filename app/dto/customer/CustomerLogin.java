package dto.customer;

/**
 * Customer authorization request DTO object
 *
 * @author corbandalas created 15.02.2016.
 * @since 0.2.0
 */
public class CustomerLogin {

    private String phone;
    private String hashedPassword;

    public CustomerLogin() {
    }

    public CustomerLogin(String phone, String hashedPassword) {
        this.phone = phone;
        this.hashedPassword = hashedPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
