package com.robinthoene.services.coreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.robinthoene")
@EntityScan("com.robinthoene.data.entities")
@SpringBootApplication(scanBasePackages = {"com.robinthoene.data.entities", "com.robinthoene.logic.interfaces", "com.robinthoene.repositories.core", "com.robinthoene.logic.core", "com.robinthoene.services.coreapi"})
public class CoreapiApplication {

    /**
     * The main entry point for the core api.
     *
     * @param args The optional start arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(CoreapiApplication.class, args);
    }

}
