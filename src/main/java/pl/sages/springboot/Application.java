package pl.sages.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // uruchamia możliwości uruchamiania metod BEANów! cyklicznie.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
