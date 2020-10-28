package services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccomplishAuthToken {
    public String token;
    public long time;


}
