package weather.server.service;

import weather.server.to.WeatherTO;

public interface WeatherService {
    public WeatherTO findCurrentWeatherByCityId(Long id);
}
