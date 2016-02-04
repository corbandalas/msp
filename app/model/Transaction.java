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

    private Operation operation;
    private Long amount;
    private Currency currency;
    private Account fromAccount;
    private Account toAccount;
    private Card card;
    private Double fromExchangeRate;
    private Double toExchangeRate;
    private TransactionType type;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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
                "operation=" + operation +
                ", amount=" + amount +
                ", currency=" + currency +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", card=" + card +
                ", fromExchangeRate=" + fromExchangeRate +
                ", toExchangeRate=" + toExchangeRate +
                '}';
    }
}
