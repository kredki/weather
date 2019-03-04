package weather.server.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CoordinatesTO {
    private BigDecimal longitude;
    private BigDecimal latitude;
}
