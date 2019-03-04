package weather.server.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weather.server.domain.CityEntity;
import weather.server.to.CityTO;

@Component
public class CityMapper {
    @Autowired
    private CoordinatesMapper coordinatesMapper;

    public CityTO toTO(CityEntity city) {
        if(city == null) {
            return null;
        }
        CityTO cityTO = new CityTO();
        cityTO.setId(city.getId());
        cityTO.setName(city.getName());
        cityTO.setCountryCode(city.getCountryCode());
        cityTO.setCoordinates(coordinatesMapper.toTo(city.getCoordinates()));
        return cityTO;
    }
}
