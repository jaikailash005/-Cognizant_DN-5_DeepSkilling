package com.cognizant.spring_learn.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Country;

@RestController
public class CountryController {

    @SuppressWarnings("unchecked")
    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return (ArrayList<Country>) context.getBean("countryList");
    }
}