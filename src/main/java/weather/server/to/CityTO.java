package weather.server.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CityTO {
    private Long id;
    private String name;
    private String countryCode;
    private CoordinatesTO coordinates;
}
