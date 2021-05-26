package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Check card provider customer password request DTO object
 * @author corbandalas created 26.05.2021.
 * @since 0.6.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckCardProviderPasswordRequest {

    private String mobilePhone;
    private String password;


}
