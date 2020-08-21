package model;

import model.enums.TransactionType;

import java.util.Date;

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
    private Long fromCardId;
    private Long toCardId;
    private Double fromAccountExchangeRate;
    private Double toAccountExchangeRate;
    private Double fromCardExchangeRate;
    private Double toCardExchangeRate;
    private TransactionType type;

    public Transaction(Long id, Long operationId, Long amount, String currencyId, Integer fromAccountId, Integer toAccountId,
                       Long fromCardId, Long toCardId, Double fromAccountExchangeRate, Double toAccountExchangeRate,
                       Double fromCardExchangeRate, Double toCardExchangeRate, TransactionType type) {
        this.setId(id);
        this.operationId = operationId;
        this.amount = amount;
        this.currencyId = currencyId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.fromCardId=fromCardId;
        this.toCardId = toCardId;
        this.fromAccountExchangeRate = fromAccountExchangeRate;
        this.toAccountExchangeRate = toAccountExchangeRate;
        this.fromCardExchangeRate=fromCardExchangeRate;
        this.toCardExchangeRate=toCardExchangeRate;
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

    public Long getFromCardId() {
        return fromCardId;
    }

    public void setFromCardId(Long fromCardId) {
        this.fromCardId = fromCardId;
    }

    public Long getToCardId() {
        return toCardId;
    }

    public void setToCardId(Long toCardId) {
        this.toCardId = toCardId;
    }

    public Double getFromAccountExchangeRate() {
        return fromAccountExchangeRate;
    }

    public void setFromAccountExchangeRate(Double fromAccountExchangeRate) {
        this.fromAccountExchangeRate = fromAccountExchangeRate;
    }

    public Double getToAccountExchangeRate() {
        return toAccountExchangeRate;
    }

    public void setToAccountExchangeRate(Double toAccountExchangeRate) {
        this.toAccountExchangeRate = toAccountExchangeRate;
    }

    public Double getFromCardExchangeRate() {
        return fromCardExchangeRate;
    }

    public void setFromCardExchangeRate(Double fromCardExchangeRate) {
        this.fromCardExchangeRate = fromCardExchangeRate;
    }

    public Double getToCardExchangeRate() {
        return toCardExchangeRate;
    }

    public void setToCardExchangeRate(Double toCardExchangeRate) {
        this.toCardExchangeRate = toCardExchangeRate;
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
                ", toCardId=" + toCardId +
                ", fromAccountExchangeRate=" + fromAccountExchangeRate +
                ", toAccountExchangeRate=" + toAccountExchangeRate +
                ", type=" + type +
                '}';
    }
}
