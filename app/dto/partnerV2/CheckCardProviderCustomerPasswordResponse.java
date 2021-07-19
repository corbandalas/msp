package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Check Card provider customer password response DTO object
 *
 * @author corbandalas created 27.05.2021.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckCardProviderCustomerPasswordResponse {

    private String firstName;
    private String lastName;

}
