package dto;

/**
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class Authentication {
    private Integer accountId;
    private String enckey;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getEnckey() {
        return enckey;
    }

    public void setEnckey(String enckey) {
        this.enckey = enckey;
    }
}
