package dto.customer;

import dto.BaseAPIResponse;

import java.util.List;

/**
 * API customer transaction response object
 * @author ra created 17.02.2016.
 * @since 0.1.0
 */
public class CustomerTransactionResponse extends BaseAPIResponse {

    private List<CustomerTransaction>transactions;

    public CustomerTransactionResponse(String text, String code, List<CustomerTransaction> transactions) {
        super(text, code);
        this.transactions=transactions;
    }

    public List<CustomerTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<CustomerTransaction> transactions) {
        this.transactions = transactions;
    }
}
