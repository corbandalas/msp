package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Card request DTO object
 *
 * @author corbandalas created 03.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerIdentificationResponse {

    private String identificationId;

}
