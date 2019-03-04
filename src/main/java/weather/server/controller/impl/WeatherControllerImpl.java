package weather.server.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import weather.server.controller.WeatherController;
import weather.server.service.WeatherService;
import weather.server.to.WeatherTO;

@RestController
public class WeatherControllerImpl implements WeatherController {
    @Autowired
    WeatherService weatherService;

    @Override
    @GetMapping("/city/{id}/weather")
    public WeatherTO findCurrentWeatherByCityId(@PathVariable Long id) {
        return weatherService.findCurrentWeatherByCityId(id);
    }
}
