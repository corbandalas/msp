package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Remove customer request DTO object
 *
 * @author corbandalas created 14.09.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveCustomerRequest {

    private String mobilePhone;
    private String cdata1;

}
