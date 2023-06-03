package ie.dcu.ee417.betteryou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ie.dcu.ee417.betteryou.entities.Feedback;
import ie.dcu.ee417.betteryou.entities.Users;

@ComponentScan(basePackages = "ie.dcu.ee417.betteryou.*")
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "ie.dcu.ee417.betteryou.repository" })
@EntityScan(basePackageClasses = {Feedback.class, Users.class})
public class betteryouApplication {

	public static void main(String[] args) {
		SpringApplication.run(betteryouApplication.class, args);
	}

}
