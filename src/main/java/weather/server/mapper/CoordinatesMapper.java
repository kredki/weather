package weather.server.mapper;

import org.springframework.stereotype.Component;
import weather.server.domain.CoordinatesEmbeddedInTable;
import weather.server.to.CoordinatesTO;

@Component
public class CoordinatesMapper {
    CoordinatesTO toTo(CoordinatesEmbeddedInTable coordinatesEmbeddedInTable) {
        CoordinatesTO coordinatesTO = new CoordinatesTO();
        coordinatesTO.setLatitude(coordinatesEmbeddedInTable.getLatitude());
        coordinatesTO.setLongitude(coordinatesEmbeddedInTable.getLongitude());
        return coordinatesTO;
    }
}
