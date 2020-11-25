package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Success API response for Partner V2 API
 *
 * @author corbandalas - created 26.11.2020
 * @since 0.1.0
 *
 */

@Data
@AllArgsConstructor
public class GetCardDetailsResponse {

    private String token;
    private String panNumber;
    private String cvv;
    private String expDate;
}
