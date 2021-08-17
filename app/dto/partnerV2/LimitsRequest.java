package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get limits request DTO object
 *
 * @author corbandalas created 17.08.2021.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitsRequest {

    private String token;
}
