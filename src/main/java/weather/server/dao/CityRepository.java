package weather.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.server.domain.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long>, CityRepositoryCustom {
}
