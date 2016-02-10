package dto;

import model.Operation;

import java.util.List;

/**
 * API operation list response
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class OperationListResponse extends BaseAPIResponse {
    private List<Operation> operationList;

    public OperationListResponse(String text, String code, List<Operation> operations) {
        super(text, code);
        this.operationList = operations;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }
}
