package dto.partnerV2;

import accomplish.dto.user.CreateUserResponse;
import dto.BaseAPIResponse;
import provider.dto.CardCreationResponse;

/**
 * Create Card request DTO object
 *
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */

public class CreateCustomerResponse extends BaseAPIResponse {
    private CreateUserResponse createUserResponse;

    public CreateCustomerResponse(String text, String code, CreateUserResponse createUserResponse) {
        super(text, code);
        this.createUserResponse = createUserResponse;
    }

    public CreateUserResponse getCreateUserResponse() {
        return createUserResponse;
    }

    public void setCreateUserResponse(CreateUserResponse createUserResponse) {
        this.createUserResponse = createUserResponse;
    }
}
