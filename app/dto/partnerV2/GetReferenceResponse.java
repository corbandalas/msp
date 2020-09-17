package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Success API response for Partner V2 API
 *
 * @author corbandalas - created 17.09.2020
 * @since 0.1.0
 *
 */

@Data
@AllArgsConstructor
public class GetReferenceResponse {

    private String reference;
}
