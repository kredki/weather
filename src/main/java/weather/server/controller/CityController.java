package weather.server.controller;

import weather.server.to.CityTO;

public interface CityController {
    public CityTO findCityById(Long id);
}
