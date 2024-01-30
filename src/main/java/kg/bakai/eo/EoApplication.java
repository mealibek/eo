package kg.bakai.eo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EoApplication.class, args);
			  
	}

}
