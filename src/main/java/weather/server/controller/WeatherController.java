package weather.server.controller;

import net.aksingh.owmjapis.api.APIException;
import weather.server.to.CurrentWeatherTO;

public interface WeatherController {
    public CurrentWeatherTO findCurrentWeatherByCityId(Long id) throws APIException;
}
