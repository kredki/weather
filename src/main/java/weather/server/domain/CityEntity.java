package weather.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CITIES")
public class CityEntity {

    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRY")
    private String countryCode;

    @Embedded
    private CoordinatesEmbeddedInTable coordinates;
}
