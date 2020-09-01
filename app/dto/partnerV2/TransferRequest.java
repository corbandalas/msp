package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Transfer Card request DTO object
 *
 * @author corbandalas created 15.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {

    private String token;
    private String receiver;
    private float amount;
    private String currency;
    private String queue;

}
