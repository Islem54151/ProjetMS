package tn.esprit.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackages = "tn.esprit.spring.repository")
public class EmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}


}
