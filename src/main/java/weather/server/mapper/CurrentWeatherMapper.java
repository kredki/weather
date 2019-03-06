package weather.server.mapper;

import net.aksingh.owmjapis.model.CurrentWeather;
import org.springframework.stereotype.Component;
import weather.server.to.CurrentWeatherTO;

@Component
public class CurrentWeatherMapper {
    public CurrentWeatherTO toTO(CurrentWeather currentWeatherFromAPI) {
        return null;
    }
}
