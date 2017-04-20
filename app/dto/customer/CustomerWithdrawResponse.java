package dto.customer;

import dto.BaseAPIResponse;

/**
 * API customer withdraw response
 * @author corbandalas created 19.04.2017.
 * @since 0.5.0
 */
public class CustomerWithdrawResponse extends BaseAPIResponse {
    private Long operationId;

    public CustomerWithdrawResponse(String text, String code, Long operationId) {
        super(text, code);
        this.operationId=operationId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
}
