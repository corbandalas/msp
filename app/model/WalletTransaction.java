package model;


/**
 * Database stored entity for managing operation wallet transactions across the project
 *
 * @author tar - created 21.08.2020
 * @since 0.1.0
 */
public class WalletTransaction extends BaseEntity<Long> {


    private Long amount_cts;
    private String currency;
    private Long  date_added;
    private String type;
    private String description;
    private String src_token;
    private String dest_token;
    private String uuid;


    public WalletTransaction() {
    }

    public WalletTransaction(Long id, Long amount_cts, String currency, Long date_added, String type, String description, String src_token, String dest_token, String uuid) {
        this.setId(id);
        this.amount_cts = amount_cts;
        this.currency = currency;
        this.date_added = date_added;
        this.type = type;
        this.description = description;
        this.src_token = src_token;
        this.dest_token = dest_token;
        this.uuid = uuid;
    }

    public Long getAmount_cts() {
        return amount_cts;
    }

    public void setAmount_cts(Long amount_cts) {
        this.amount_cts = amount_cts;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getDate_added() {
        return date_added;
    }

    public void setDate_added(Long date_added) {
        this.date_added = date_added;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSrc_token() {
        return src_token;
    }

    public void setSrc_token(String src_token) {
        this.src_token = src_token;
    }

    public String getDest_token() {
        return dest_token;
    }

    public void setDest_token(String dest_token) {
        this.dest_token = dest_token;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "WalletTransaction{" +
                "amount_cts=" + amount_cts +
                ", currency='" + currency + '\'' +
                ", date_added=" + date_added +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", src_token='" + src_token + '\'' +
                ", dest_token='" + dest_token + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
