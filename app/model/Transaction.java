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
    private Currency currency;
    private Integer fromAccountId;
    private Integer toAccountId;
    private Long cardId;
    private Double fromExchangeRate;
    private Double toExchangeRate;
    private TransactionType type;

    public Long getOperation() {
        return operationId;
    }

    public void setOperation(Long operationId) {
        this.operationId = operationId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccount(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccount(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCard(Long cardId) {
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

    @Override
    public String toString() {
        return "Transaction{" +
                "operationId=" + operationId +
                ", amount=" + amount +
                ", currency=" + currency +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", cardId=" + cardId +
                ", fromExchangeRate=" + fromExchangeRate +
                ", toExchangeRate=" + toExchangeRate +
                '}';
    }
}
