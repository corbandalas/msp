package dto;

import model.Operation;

/**
 * API operation response
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class OperationResponse extends BaseAPIResponse {

    private Operation operation;

    public OperationResponse(String text, String code, Operation operation) {
        super(text, code);
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
