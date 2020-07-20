package dto.partnerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Load card request DTO object
 *
 * @author corbandalas created 17.07.2020.
 * @since 0.6.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadRequest {

    private String token;
    private String label;
    private String amount;
    private String reference;

}
