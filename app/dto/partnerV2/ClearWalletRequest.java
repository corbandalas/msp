package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clean mini wallet  request DTO object
 *
 * @author corbandalas created 27.08.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClearWalletRequest {

    private String uuid;
    private String action;

}
