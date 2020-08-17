package dto.partnerV2;

import dto.partnerV2.entity.CustomerV2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Card request DTO object
 *
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerResponse  {

    private CustomerV2 customer;

}
