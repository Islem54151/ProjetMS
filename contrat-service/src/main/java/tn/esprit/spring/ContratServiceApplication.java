package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@EnableEurekaClient
@EnableFeignClients(basePackages = "tn.esprit.spring.services")
@SpringBootApplication
public class ContratServiceApplication  {

    public static void main(String[] args) {

        SpringApplication.run(ContratServiceApplication.class, args);


    }
    @PostConstruct
    public void testDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL driver not found.");
        }
    }





}
