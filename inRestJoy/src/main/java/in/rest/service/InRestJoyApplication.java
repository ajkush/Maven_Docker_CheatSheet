package in.rest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("in.rest.domain")
@ComponentScan("in.rest")
public class InRestJoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InRestJoyApplication.class, args);
	}
}
