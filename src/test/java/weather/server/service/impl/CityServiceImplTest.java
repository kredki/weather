package weather.server.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import weather.server.dao.CityRepository;
import weather.server.domain.CityEntity;
import weather.server.domain.CoordinatesEmbeddedInTable;
import weather.server.exception.CityNotFoundException;
import weather.server.mapper.CityMapper;
import weather.server.to.CityTO;
import weather.server.to.CoordinatesTO;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CityServiceImplTest {
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CityMapper cityMapper;

    @InjectMocks
    CityServiceImpl cityService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindCityById() {
        // given
        Long id = 1L;
        String name = "city";
        String countryCode = "UK";
        BigDecimal latitude = new BigDecimal("22.3456");
        BigDecimal longitude = new BigDecimal("13.7894");
        CoordinatesEmbeddedInTable coordinates = new CoordinatesEmbeddedInTable();
        coordinates.setLatitude(latitude);
        coordinates.setLongitude(longitude);
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCoordinates(coordinates);
        cityEntity.setCountryCode(countryCode);
        cityEntity.setId(id);
        cityEntity.setName(name);

        CoordinatesTO coordinatesTO= new CoordinatesTO();
        coordinatesTO.setLongitude(longitude);
        coordinatesTO.setLatitude(latitude);
        CityTO cityTO = new CityTO();
        cityTO.setCoordinates(coordinatesTO);
        cityTO.setName(name);
        cityTO.setCountryCode(countryCode);
        cityTO.setId(id);

        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.of(cityEntity));
        Mockito.when(cityMapper.toTO(cityEntity)).thenReturn(cityTO);

        // when
        CityTO result = cityService.findCityById(id);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getCoordinates().getLatitude()).isEqualTo(cityTO.getCoordinates().getLatitude());
        assertThat(result.getCoordinates().getLongitude()).isEqualTo(cityTO.getCoordinates().getLongitude());
        assertThat(result.getCountryCode()).isEqualTo(cityTO.getCountryCode());
        assertThat(result.getId()).isEqualTo(cityTO.getId());
        assertThat(result.getName()).isEqualTo(cityTO.getName());
        Mockito.verify(cityRepository, Mockito.times(1)).findById(id);
        Mockito.verify(cityMapper, Mockito.times(1)).toTO(cityEntity);
    }

    @Test
    public void shouldNotFindCityById() {
        // given
        Long id = 1L;
        boolean exceptionCaught = false;
        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.ofNullable(null));
        Mockito.when(cityMapper.toTO(null)).thenReturn(null);

        // when
        CityTO result = null;
        try {
            result = cityService.findCityById(id);
        } catch (CityNotFoundException e) {
            exceptionCaught = true;
        }

        // then
        assertThat(exceptionCaught).isTrue();
        Mockito.verify(cityRepository, Mockito.times(1)).findById(id);
        Mockito.verify(cityMapper, Mockito.never()).toTO(Mockito.any());
    }
}