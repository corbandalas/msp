package dto;

import model.Transaction;

/**
 * API transaction response
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class TransactionResponse extends BaseAPIResponse {
    private Transaction transaction;

    public TransactionResponse(String text, String code, Transaction transaction) {
        super(text, code);
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
