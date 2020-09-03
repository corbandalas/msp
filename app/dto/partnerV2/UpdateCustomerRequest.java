package dto.partnerV2;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Check card request DTO object
 *
 * @author corbandalas created 20.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    private String type;
    @JsonRawValue
    private Object data;
    private String mobilePhone;
    private String cdata1;
    private String token;
    private String email;

}
