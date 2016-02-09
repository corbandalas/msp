package dto;

import model.Account;

/**
 * Account response
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class AccountResponse extends BaseAPIResponse {

    private Account account;

    public AccountResponse(String text, String code, Account account) {
        super(text, code);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
