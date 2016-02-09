package dto;

import model.Account;

/**
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class Authentication {
    private Account account;
    private String enckey;
    private String orderId;

    public Authentication(Account account, String enckey, String orderId) {
        this.account = account;
        this.enckey = enckey;
        this.orderId=orderId;
    }

    public Account getAccount() {
        return account;
    }

    public String getEnckey() {
        return enckey;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "account=" + account.toString() +
                ", enckey='" + enckey + '\'' +
                '}';
    }
}
