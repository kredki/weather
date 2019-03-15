package weather.server.service.impl;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import weather.server.dao.CityRepository;
import weather.server.domain.CityEntity;
import weather.server.mapper.CurrentWeatherMapper;
import weather.server.to.CurrentWeatherTO;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherServiceImplTest {
    @Mock
    CurrentWeatherMapper currentWeatherMapper;
    @Mock
    CityRepository cityRepository;
    @Mock
    CurrentWeather cwd;

    @InjectMocks
    WeatherServiceImpl weatherService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindCurrentWeatherByCityId() throws APIException {
        // given
        Long id = 1L;
        OWM owm = Mockito.mock(OWM.class);
        CurrentWeatherTO cwdTO = new CurrentWeatherTO();
        weatherService._testingPurposeOnlySetterForOWM(owm);

        Mockito.when(cwd.hasRespCode()).thenReturn(true);
        Mockito.when(cwd.getRespCode()).thenReturn(200);
        Mockito.when(owm.currentWeatherByCityId(id.intValue())).thenReturn(cwd);
        Mockito.when(currentWeatherMapper.toTO(cwd)).thenReturn(cwdTO);
        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.of(new CityEntity()));

        // when
        CurrentWeatherTO result = weatherService.findCurrentWeatherByCityId(id);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(cwdTO);
        Mockito.verify(owm, Mockito.times(1)).currentWeatherByCityId(id.intValue());
    }

    @Test
    public void shouldNotFindCurrentWeatherByCityId() throws APIException {
        // given
        Long id = 1L;
        OWM owm = Mockito.mock(OWM.class);
        CurrentWeatherTO cwdTO = new CurrentWeatherTO();
        weatherService._testingPurposeOnlySetterForOWM(owm);

        Mockito.when(cwd.hasRespCode()).thenReturn(true);
        Mockito.when(cwd.getRespCode()).thenReturn(200);
        Mockito.when(owm.currentWeatherByCityId(id.intValue())).thenReturn(cwd);
        Mockito.when(currentWeatherMapper.toTO(cwd)).thenReturn(cwdTO);
        Mockito.when(currentWeatherMapper.toTO(null)).thenReturn(null);
        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.ofNullable(null));

        // when
        CurrentWeatherTO result = weatherService.findCurrentWeatherByCityId(id);

        // then
        assertThat(result).isNull();
        Mockito.verify(owm, Mockito.never()).currentWeatherByCityId(id.intValue());
    }
}