package dto.customer;

/**
 * Request object for change pin
 * @author ra created 16.02.2016.
 * @since 0.2.0
 */
public class CustomerChangePassword {
    private String oldHashedPassword;
    private String hashedPassword;

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getOldHashedPassword() {
        return oldHashedPassword;
    }

    public void setOldHashedPassword(String oldHashedPassword) {
        this.oldHashedPassword = oldHashedPassword;
    }
}
