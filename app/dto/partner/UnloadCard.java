package dto.partner;

/**
 * Unload Card request DTO object
 *
 * @author corbandalas created 12.09.2017.
 * @since 0.6.0
 */
public class UnloadCard {

    private String currency;
    private String amount;
    private String token;
    private String description;
    private String loadType;


    public UnloadCard(String currency, String amount, String token, String description, String loadType) {
        this.currency = currency;
        this.amount = amount;
        this.token = token;
        this.description = description;
        this.loadType = loadType;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    @Override
    public String toString() {
        return "UnloadCard {" +
                "currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", loadType='" + loadType + '\'' +
                ", token='" + token + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
