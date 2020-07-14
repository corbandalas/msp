package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create customer document request DTO object
 * @author corbandalas created 03.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardRequest {

    private String cardModel;
    private String cardData;
    private String mobilePhone;

}
