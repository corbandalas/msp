package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get customer card provider request DTO object
 * @author corbandalas created 20.08.2021.
 * @since 0.6.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerCardProviderRequest {

    private String userID;
}
