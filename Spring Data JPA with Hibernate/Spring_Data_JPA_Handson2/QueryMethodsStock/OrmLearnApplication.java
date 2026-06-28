package com.cognizant.ormlearn;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class OrmLearnApplication {
    private static CountryService countryService;
    private static StockRepository stockRepository;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run( OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);
        testSearchCountries();
        testSearchCountriesSorted();
        testCountriesStartingWith();
        testFacebookStocks();
        testGoogleStocks();
        testHighestVolume();
        testNetflixStocks();
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

    private static void testFacebookStocks() {
        System.out.println("\nFacebook Stocks");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        stocks.forEach(System.out::println);
    }
    private static void testGoogleStocks() {
        System.out.println("\nGoogle Stocks");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan( "GOOGL", 1250);
        stocks.forEach(System.out::println);
    }
    private static void testHighestVolume() {
        System.out.println("\nHighest Volume");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(System.out::println);
    }
    private static void testNetflixStocks() {
        System.out.println("\nNetflix Lowest Stocks");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(System.out::println);
    }
}