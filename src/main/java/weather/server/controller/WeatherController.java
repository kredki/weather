package weather.server.controller;

import weather.server.to.WeatherTO;

public interface WeatherController {
    public WeatherTO findCurrentWeatherByCityId(Long id);
}
