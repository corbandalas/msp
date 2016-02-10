package dto;

import model.Transaction;

import java.util.List;

/**
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class TransactionListResponse extends BaseAPIResponse {
    private List<Transaction>transactionList;

    public TransactionListResponse(String text, String code, List<Transaction> transactionList) {
        super(text, code);
        this.transactionList = transactionList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
