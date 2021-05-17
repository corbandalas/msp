package dto.partnerV2;

import dto.partnerV2.entity.CustomerV2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Customer simpl3 request DTO object
 *
 * @author corbandalas created 17.05.2021.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerSimpleResponse {

    private String userID;

}
