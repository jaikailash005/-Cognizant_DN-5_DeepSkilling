package com.cognizant;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public Country getCountry(String code) throws CountryNotFoundException {

        System.out.println("Input = " + code);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList =
                context.getBean("countryList", List.class);

        System.out.println("Size = " + countryList.size());

        for (Country country : countryList) {

            System.out.println("Country = "
                    + country.getCode() + " "
                    + country.getName());

            if (country.getCode().equalsIgnoreCase(code)) {

                System.out.println("FOUND");

                return country;
            }
        }

        System.out.println("NOT FOUND");

        throw new CountryNotFoundException();
    }
}