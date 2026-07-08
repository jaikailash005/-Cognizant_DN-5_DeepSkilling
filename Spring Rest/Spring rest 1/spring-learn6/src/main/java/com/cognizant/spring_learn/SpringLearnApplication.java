package com.cognizant.spring_learn;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        LOGGER.info("START");

        SpringApplication.run(SpringLearnApplication.class, args);

        displayCountries();

        LOGGER.info("Application Started Successfully");

        LOGGER.info("END");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        ArrayList<Country> countries =
                (ArrayList<Country>) context.getBean("countryList");

        for (Country country : countries) {

            LOGGER.debug("{}", country);

        }

        ((ClassPathXmlApplicationContext) context).close();

        LOGGER.info("END");
    }
}