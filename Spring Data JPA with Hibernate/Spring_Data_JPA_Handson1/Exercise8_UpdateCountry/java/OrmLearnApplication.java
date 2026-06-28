package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER=
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context=
                SpringApplication.run(OrmLearnApplication.class,args);

        countryService=context.getBean(CountryService.class);

        testUpdateCountry();

    }

    private static void testUpdateCountry() {

        LOGGER.info("Start");

        try {

            countryService.updateCountry(
                    "NP",
                    "Federal Democratic Republic of Nepal");

            Country country =
                    countryService.findCountryByCode("NP");

            LOGGER.debug("Country : {}", country);

        }

        catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

        LOGGER.info("End");

    }

}