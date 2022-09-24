package com.robinthoene.jav42.coreapi.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.robinthoene.jav42.coreapi")
@EntityScan("com.robinthoene.jav42.coreapi.data.entities")
@SpringBootApplication(scanBasePackages = {
        "com.robinthoene.jav42.coreapi.data.entities",
        "com.robinthoene.jav42.coreapi.logic.interfaces",
        "com.robinthoene.jav42.coreapi.repositories.core",
        "com.robinthoene.jav42.coreapi.logic.authorization",
        "com.robinthoene.jav42.coreapi.logic.core",
        "com.robinthoene.jav42.coreapi.services"
})
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
