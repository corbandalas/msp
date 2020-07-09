package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base API response for Partner V2 API
 *
 * @author corbandalas - created 08.07.2020
 * @since 0.1.0
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseAPIV2ErrorResponse {

    private String message;
    private String code;
    private String details;
    private String number;

}
