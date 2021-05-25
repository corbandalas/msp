package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create customer request DTO object
 * @author corbandalas created 17.05.2021.
 * @since 0.6.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerSimpleRequest {

    private String email;
    private String password;
    private String phone;
    private String country;
    private String currency;

}
