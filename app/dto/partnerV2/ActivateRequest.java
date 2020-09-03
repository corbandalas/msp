package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Activate card request DTO object
 *
 * @author corbandalas created 16.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivateRequest {

    private String token;
    private String lastName;
    private String mobilePhone;
    private String cdata1;
    private String lastDigits;

}
