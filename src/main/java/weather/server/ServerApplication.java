package weather.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {
	public static void main(String[] args) {
		// Uncomment line below to use mysql database
		System.setProperty("spring.profiles.active", "mysql");
		SpringApplication.run(ServerApplication.class, args);
	}

}
