package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Transaction request DTO object
 *
 * @author corbandalas created 24.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private String token;
    private String dateStart;
    private String dateEnd;
    private String limit;
    private String offset;
    private String status;

}
