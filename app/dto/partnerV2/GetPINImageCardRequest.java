package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get card pin image request DTO object
 *
 * @author corbandalas created 23.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPINImageCardRequest {

    private String token;

}
