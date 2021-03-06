package weather.server.service.impl;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import weather.server.dao.CityRepository;
import weather.server.exception.WeatherDataValidationException;
import weather.server.mapper.CurrentWeatherMapper;
import weather.server.service.WeatherService;
import weather.server.to.CurrentWeatherTO;

import javax.annotation.PostConstruct;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Value("${apikey}")
    private String apiKey;

    @Autowired
    private CurrentWeatherMapper currentWeatherMapper;

    @Autowired
    private CityRepository cityRepository;

    private OWM owm;

    @PostConstruct
    private void init() {
        this.owm = new OWM(apiKey);
        this.owm.setUnit(OWM.Unit.METRIC);
    }

    @Override
    public CurrentWeatherTO findCurrentWeatherByCityId(Long id) throws APIException {
        if(!cityRepository.findById(id).isPresent()) {
            return null;
        }

        CurrentWeather cwd = owm.currentWeatherByCityId(id.intValue());
        if (!cwd.hasRespCode() || !(cwd.getRespCode() == 200)) {
            throw new WeatherDataValidationException("Data has no response code or code is not 200");
        }
        return currentWeatherMapper.toTO(cwd);
    }

    // method for test purpose only
    public void _testingPurposeOnlySetterForOWM (OWM owm) {
        this.owm = owm;
    }
}
