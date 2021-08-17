package dto.partnerV2;

import accomplish.dto.limits.AccountLimitsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get limits response DTO object
 *
 * @author corbandalas created 17.08.2021.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitsResponse {
    private AccountLimitsResponse accountLimitsResponse;

}
