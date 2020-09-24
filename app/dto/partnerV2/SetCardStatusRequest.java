package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Set card status request DTO object
 *
 * @author corbandalas created 24.09.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetCardStatusRequest {

    private String token;
    private String newStatus;

}
