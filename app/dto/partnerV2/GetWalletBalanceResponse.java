package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get mini wallet balance response DTO object
 *
 * @author corbandalas created 25.08.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetWalletBalanceResponse {

    private String uuid;
    private float balance;
    private String currency;


}
