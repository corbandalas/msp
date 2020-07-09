package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create customer identification request DTO object
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerIdentificationRequest {

    private String email;
    private String issuanceCountry;
    private String residenceCountry;
    private String issueDate;
    private String expiryDate;
    private String type;
    private String number;


}
