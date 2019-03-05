package weather.server.service.impl;

import org.springframework.stereotype.Service;
import weather.server.service.WeatherService;
import weather.server.to.WeatherTO;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherTO findCurrentWeatherByCityId(Long id) {
        return null;
    }
}
