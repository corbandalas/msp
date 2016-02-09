package dto;

import model.Account;

import java.util.List;

/**
 * Account list response
 *
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class AccountListResponse extends BaseAPIResponse {

    private List<Account> accounts;

    public AccountListResponse(String text, String code, List<Account> accounts) {
        super(text, code);
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
