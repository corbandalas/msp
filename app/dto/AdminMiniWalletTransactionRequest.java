package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get mini wallet transaction DTO object
 *
 * @author corbandalas created 24.08.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMiniWalletTransactionRequest {

    private String uuid;
    private String dateStart;
    private String dateEnd;
    private String sourceToken;
    private String destToken;

}
