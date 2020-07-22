package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Check card request DTO object
 *
 * @author corbandalas created 20.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    private String type;
    private String data;
    private String mobilePhone;

}
