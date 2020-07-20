package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Success API response for Partner V2 API
 *
 * @author corbandalas - created 20.07.2020
 * @since 0.1.0
 *
 */

@Data
@AllArgsConstructor
public class CheckCardResponse {

    private String token;
    private String status;
    private String activationDate;
    private String balance;
    private String cardData;
    private String currency;
    private String group;
    private String panNumber;
    private String type;
    private String walletReference;
}
