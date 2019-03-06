package weather.server.exception;

public class WeatherDataValidationException extends RuntimeException {
    public WeatherDataValidationException(String message) {
        super(message);
    }

    public WeatherDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
