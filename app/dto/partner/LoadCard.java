package dto.partner;

/**
 * Load Card request DTO object
 *
 * @author corbandalas created 12.09.2017.
 * @since 0.6.0
 */
public class LoadCard {

    private String currency;
    private String amount;
    private String token;
    private String source;
    private String description;


    public LoadCard(String currency, String amount, String token, String source, String description) {
        this.currency = currency;
        this.amount = amount;
        this.token = token;
        this.source = source;
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    @Override
    public String toString() {
        return "LoadCard{" +
                "currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", token='" + token + '\'' +
                ", description='" + description + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
