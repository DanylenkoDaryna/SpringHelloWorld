package com.example.demo4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication4 {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication4.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication4.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("John", "Snow"));
            repository.save(new Customer("Diana", "Prince"));
            repository.save(new Customer("Donna", "Rosa"));
            repository.save(new Customer("Ragulyvna", "PTS"));
            repository.save(new Customer("Ramzy", "Snow"));
            repository.save(new Customer("Skrypin", "ua"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Skrypin'):");
            log.info("--------------------------------------------");
            repository.findByLastName("ua").forEach(snow -> {
                log.info(snow.toString());
            });
            log.info("");
            for (Customer snow : repository.findByLastName("Snow")) {
              log.info(snow.toString());
             }
            log.info("");
        };
    }
}
