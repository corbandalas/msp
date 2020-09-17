package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Get transaction reference request DTO object
 *
 * @author corbandalas created 17.09.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReferenceRequest {

    private String sourceID;

}
