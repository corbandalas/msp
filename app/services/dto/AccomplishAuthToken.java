package services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AccomplishAuthToken implements Serializable {
    public String token;
    public long time;
    public Integer expires;

}
