package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Success API response for Partner V2 API
 *
 * @author corbandalas - created 20.07.2020
 * @since 0.1.0
 *
 */

@Data
@AllArgsConstructor
public class LoadResponse extends  SuccessAPIV2Response{
    private String token;
    private String status;
    private String amount;
    private String walletBalance;
    private String reference;
}
