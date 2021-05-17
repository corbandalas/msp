package dto.partnerV2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Connect customer request DTO object
 * @author corbandalas created 17.05.2021.
 * @since 0.6.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectCustomerRequest {

    private String userID;
}
