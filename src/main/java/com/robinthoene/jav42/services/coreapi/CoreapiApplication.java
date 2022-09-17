package com.robinthoene.jav42.services.coreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.robinthoene.jav42")
@EntityScan("com.robinthoene.jav42.data.entities")
@SpringBootApplication(scanBasePackages = {
        "com.robinthoene.jav42.data.entities",
        "com.robinthoene.jav42.logic.interfaces",
        "com.robinthoene.jav42.repositories.core",
        "com.robinthoene.jav42.logic.core",
        "com.robinthoene.jav42.services.coreapi"
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
