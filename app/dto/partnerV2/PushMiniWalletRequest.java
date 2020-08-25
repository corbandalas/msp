package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Push mini wallet transaction DTO object
 *
 * @author corbandalas created 24.08.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushMiniWalletRequest {

    private String token;
    private String receiver;
    private String uuid;
    private String description;
    private float amount;

}
