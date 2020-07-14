package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get customer request DTO object
 * @author corbandalas created 09.07.2020.
 * @since 0.6.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerRequest {

    private String mobilePhone;

}
