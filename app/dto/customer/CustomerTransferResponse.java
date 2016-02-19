package dto.customer;

import dto.BaseAPIResponse;

/**
 * API customer transfer response
 * @author ra created 19.02.2016.
 * @since 0.1.0
 */
public class CustomerTransferResponse extends BaseAPIResponse {
    private Long operationId;

    public CustomerTransferResponse(String text, String code,Long operationId) {
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
