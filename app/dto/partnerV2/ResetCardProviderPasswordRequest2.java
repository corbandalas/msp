package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Reset card provider customer password request DTO object
 * @author corbandalas created 23.06.2021.
 * @since 0.6.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetCardProviderPasswordRequest2 {

    private String email;
    private String currentPassword;
    private String newPassword;

}
