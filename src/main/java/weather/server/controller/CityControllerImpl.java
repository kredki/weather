package weather.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import weather.server.service.CityService;
import weather.server.to.CityTO;

@RestController
public class CityControllerImpl implements CityController{

    @Autowired
    private CityService cityService;

    @Override
    @GetMapping("/city/{id}")
    public CityTO findCityById(@PathVariable Integer id) {
        return cityService.findCityById(id);
    }
}
