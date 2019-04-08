package ashwin.joshi.xmlxslt;

import ashwin.joshi.xmlxslt.config.StorageProperties;
import ashwin.joshi.xmlxslt.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run();
	}

	@Bean
	CommandLineRunner init(StorageService service){
		return (args) -> {
			service.deleteAll();
			service.init();
		};
	}

}
