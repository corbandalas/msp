package dto.customer;

import model.enums.FeeDestinationType;
import model.enums.OperationType;

import java.io.Serializable;

/**
 * Obtain operation fee request DTO
 *
 * @author corbandalas created 18.05.2017.
 * @since 0.4.0
 */
public class ObtainFeeRequest implements Serializable{

    private Long amount;
    private String currency;
    private OperationType operationType;
    private FeeDestinationType feeDestinationType;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public FeeDestinationType getFeeDestinationType() {
        return feeDestinationType;
    }

    public void setFeeDestinationType(FeeDestinationType feeDestinationType) {
        this.feeDestinationType = feeDestinationType;
    }
}
