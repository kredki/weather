package weather.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.server.dao.CityRepository;
import weather.server.domain.CityEntity;
import weather.server.exception.CityNotFoundException;
import weather.server.mapper.CityMapper;
import weather.server.service.CityService;
import weather.server.to.CityTO;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityMapper cityMapper;

    @Override
    public CityTO findCityById(Long id) {
        Optional<CityEntity> cityFromDB = cityRepository.findById(id);
        if(cityFromDB.isPresent()) {
            return cityMapper.toTO(cityFromDB.get());
        }
        throw new CityNotFoundException("city of id " + id + " not found");
    }
}
