package dto;


import java.util.List;

/**
 * Account balance response
 *
 * @author ra created 28.09.2020.
 * @since 0.1.0
 */
public class AccountBalanceResponse extends BaseAPIResponse {

    private List<dto.partnerV2.account.balance.response.GetBINBalanceResponse> accounts;

    public AccountBalanceResponse(String text, String code, List<dto.partnerV2.account.balance.response.GetBINBalanceResponse> accounts) {
        super(text, code);
        this.accounts = accounts;
    }

    public List<dto.partnerV2.account.balance.response.GetBINBalanceResponse> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<dto.partnerV2.account.balance.response.GetBINBalanceResponse> accounts) {
        this.accounts = accounts;
    }
}
