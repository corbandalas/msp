package model;

import model.enums.TransactionType;

/**
 * Database stored entity for managing operation transactions across the project
 * Entity id - phone number in international format without leading '+'
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
public class Transaction extends BaseEntity<Long> {

    private Long operationId;
    private Long amount;
    private String currencyId;
    private Integer fromAccountId;
    private Integer toAccountId;
    private Long cardId;
    private Double fromExchangeRate;
    private Double toExchangeRate;
    private TransactionType type;

    public Transaction(Long id, Long operationId, Long amount, String currencyId, Integer fromAccountId, Integer toAccountId, Long cardId, Double fromExchangeRate, Double toExchangeRate, TransactionType type) {
        this.setId(id);
        this.operationId = operationId;
        this.amount = amount;
        this.currencyId = currencyId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.cardId = cardId;
        this.fromExchangeRate = fromExchangeRate;
        this.toExchangeRate = toExchangeRate;
        this.type = type;
    }

    public Transaction() {
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Double getFromExchangeRate() {
        return fromExchangeRate;
    }

    public void setFromExchangeRate(Double fromExchangeRate) {
        this.fromExchangeRate = fromExchangeRate;
    }

    public Double getToExchangeRate() {
        return toExchangeRate;
    }

    public void setToExchangeRate(Double toExchangeRate) {
        this.toExchangeRate = toExchangeRate;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "operationId=" + operationId +
                ", amount=" + amount +
                ", currencyId=" + currencyId +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", cardId=" + cardId +
                ", fromExchangeRate=" + fromExchangeRate +
                ", toExchangeRate=" + toExchangeRate +
                ", type=" + type +
                '}';
    }
}
