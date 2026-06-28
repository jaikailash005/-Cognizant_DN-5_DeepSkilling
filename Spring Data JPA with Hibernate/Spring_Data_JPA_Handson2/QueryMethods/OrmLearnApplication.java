package com.cognizant.ormlearn;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class OrmLearnApplication {
    private static CountryService countryService;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testSearchCountries();
        testSearchCountriesSorted();
        testCountriesStartingWith();
    }
    private static void testSearchCountries() {
        System.out.println("\nCountries containing 'ou'");
        List<Country> countries = countryService.searchCountries("ou");
        countries.forEach(System.out::println);
    }
    private static void testSearchCountriesSorted() {
        System.out.println("\nSorted Countries");
        List<Country> countries = countryService.searchCountriesSorted("ou");
        countries.forEach(System.out::println);
    }
    private static void testCountriesStartingWith() {
        System.out.println("\nCountries starting with Z");
        List<Country> countries = countryService.searchCountriesStartingWith("Z");
        countries.forEach(System.out::println);
    }
}