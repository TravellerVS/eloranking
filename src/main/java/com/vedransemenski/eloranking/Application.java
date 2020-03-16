package com.vedransemenski.eloranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static Logger LOGGER = LoggerFactory
            .getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("STARTING THE APPLICATION");
        SpringApplication.run(Application.class, args);
        LOGGER.info("APPLICATION FINISHED");
    }

}
