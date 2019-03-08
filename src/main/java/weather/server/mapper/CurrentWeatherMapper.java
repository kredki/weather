package weather.server.mapper;

import net.aksingh.owmjapis.model.CurrentWeather;
import org.springframework.stereotype.Component;
import weather.server.to.CurrentWeatherTO;

@Component
public class CurrentWeatherMapper {
    public CurrentWeatherTO toTO(CurrentWeather currentWeatherFromAPI) {
        if (currentWeatherFromAPI == null) {
            return null;
        }
        CurrentWeatherTO mappedTO = new CurrentWeatherTO();
        mappedTO.setWindData(currentWeatherFromAPI.getWindData());
        mappedTO.setWeatherList(currentWeatherFromAPI.getWeatherList());
        mappedTO.setSnowData(currentWeatherFromAPI.getSnowData());
        mappedTO.setRainData(currentWeatherFromAPI.getRainData());
        mappedTO.setDate(currentWeatherFromAPI.getDateTime());
        mappedTO.setCloudData(currentWeatherFromAPI.getCloudData());
        mappedTO.setCityId(currentWeatherFromAPI.getCityId());
        mappedTO.setCityName(currentWeatherFromAPI.getCityName());
        mappedTO.setMainData(currentWeatherFromAPI.getMainData());
        return mappedTO;
    }
}
