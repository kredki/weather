package weather.server.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.aksingh.owmjapis.model.param.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CurrentWeatherTO {
    private Wind windData;
    private List<Weather> weatherList;
    private Snow snowData;
    private Rain rainData;
    private Date date;
    private Cloud cloudData;
    private Integer cityId;
    private String cityName;
    private Main mainData;
}