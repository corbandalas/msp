package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Change card fulfilment request DTO object
 *
 * @author corbandalas created 27.08.2021.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeCardFulfilmentRequest {

    private String token;
    private String fulfilment;

}
