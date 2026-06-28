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

        testFindCountryByCode();

    }

    private static void testFindCountryByCode(){

        LOGGER.info("Start");

        try{

            Country country=countryService.findCountryByCode("IN");

            LOGGER.debug("Country : {}",country);

        }

        catch(CountryNotFoundException e){

            LOGGER.error(e.getMessage());

        }

        LOGGER.info("End");

    }

}