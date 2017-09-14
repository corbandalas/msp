package dto.partner;

/**
 * Card balance request DTO object
 *
 * @author corbandalas created 14.09.2017.
 * @since 0.6.0
 */
public class Balance {

    private String token;

    public Balance(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
