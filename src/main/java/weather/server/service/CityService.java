package weather.server.service;

import weather.server.to.CityTO;

public interface CityService {
    public CityTO findCityById(Long id);
}
