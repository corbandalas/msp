package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get customer document request DTO object
 * @author corbandalas created 26.10.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDocumentRequest {

    private String mobilePhone;
    private String cdata1;

}
