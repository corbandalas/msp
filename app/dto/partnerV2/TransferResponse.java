package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Success API response for Partner V2 API
 *
 * @author corbandalas - created 08.07.2020
 * @since 0.1.0
 *
 */

@Data
@AllArgsConstructor
public class TransferResponse extends  SuccessAPIV2Response{
    private boolean success;
    private String status;
}
