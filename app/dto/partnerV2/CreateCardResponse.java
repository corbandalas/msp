package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Card response DTO object
 *
 * @author corbandalas created 14.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardResponse {

    private String activationDate;
    private String balance;
    private String cardData;
    private String currency;
    private String group;
    private String panNumber;
    private String status;
    private String token;
    private String type;
    private String walletReference;

}
