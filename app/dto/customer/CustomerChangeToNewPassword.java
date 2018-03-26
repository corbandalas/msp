package dto.customer;

/**
 * Request object for change pin
 * @author corbandalas created 26.03.2018.
 * @since 0.4.0
 */
public class CustomerChangeToNewPassword {
    private String hashedPassword;

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

}
