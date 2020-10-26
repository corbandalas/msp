package dto.partnerV2;

import accomplish.dto.account.document.GetDocumentResponse;
import dto.partnerV2.entity.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Document request DTO object
 *
 * @author corbandalas created 05.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerDocumentResponse {

    private GetDocumentResponse getDocumentResponse;
}
