package dto;

import model.Operation;

import java.util.List;

/**
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class OperationListResponse extends BaseAPIResponse {
    private List<Operation>operations;

    public OperationListResponse(String text, String code, List<Operation> operations) {
        super(text, code);
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
