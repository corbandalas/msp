package model;

import model.enums.OperationType;

/**
 * Database stored entity for managing operations across the project
 * Entity id - phone number in international format without leading '+'
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
public class Operation extends BaseEntity<Long> {

    private OperationType type;
    private String orderId;
    private String description;

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "type=" + type +
                ", orderId='" + orderId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
