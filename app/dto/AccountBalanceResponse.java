package dto;


import accomplish.dto.account.balance.response.GetBINBalanceResponse;

import java.util.List;

/**
 * Account balance response
 *
 * @author ra created 28.09.2020.
 * @since 0.1.0
 */
public class AccountBalanceResponse extends BaseAPIResponse {

    private List<GetBINBalanceResponse> accounts;

    public AccountBalanceResponse(String text, String code, List<GetBINBalanceResponse> accounts) {
        super(text, code);
        this.accounts = accounts;
    }

    public List<GetBINBalanceResponse> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<GetBINBalanceResponse> accounts) {
        this.accounts = accounts;
    }
}
