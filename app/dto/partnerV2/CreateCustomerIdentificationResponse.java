package dto.partnerV2;

import accomplish.dto.identification.CreateIdentificationResponse;
import accomplish.dto.user.CreateUserResponse;
import dto.BaseAPIResponse;

/**
 * Create Card request DTO object
 *
 * @author corbandalas created 03.07.2020.
 * @since 0.6.0
 */

public class CreateCustomerIdentificationResponse extends BaseAPIResponse {
    private CreateIdentificationResponse createIdentificationResponse;

    public CreateCustomerIdentificationResponse(String text, String code, CreateIdentificationResponse createIdentificationResponse) {
        super(text, code);
        this.createIdentificationResponse = createIdentificationResponse;
    }

    public CreateIdentificationResponse getCreateIdentificationResponse() {
        return createIdentificationResponse;
    }

    public void setCreateIdentificationResponse(CreateIdentificationResponse createIdentificationResponse) {
        this.createIdentificationResponse = createIdentificationResponse;
    }
}
