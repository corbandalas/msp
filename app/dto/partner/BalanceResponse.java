package dto.partner;

import ae.globalprocessing.hyperionweb.BalanceEnquire2;
import dto.BaseAPIResponse;
import provider.dto.CardCreationResponse;

/**
 * Card Balance response DTO object
 *
 * @author corbandalas created 14.09.2017.
 * @since 0.6.0
 */

public class BalanceResponse extends BaseAPIResponse {

    private BalanceEnquire2 balance;

    public BalanceResponse(String text, String code, BalanceEnquire2 balance) {
        super(text, code);
        this.balance = balance;
    }

    public BalanceEnquire2 getBalance() {
        return balance;
    }

    public void setBalance(BalanceEnquire2 balance) {
        this.balance = balance;
    }
}
