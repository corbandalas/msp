package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get mini wallet balance request DTO object
 *
 * @author corbandalas created 25.08.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetWalletBalanceRequest {

    private String uuid;

}
