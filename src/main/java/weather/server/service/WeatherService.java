package weather.server.service;

import net.aksingh.owmjapis.api.APIException;
import weather.server.to.CurrentWeatherTO;

public interface WeatherService {
    public CurrentWeatherTO findCurrentWeatherByCityId(Long id) throws APIException;
}
