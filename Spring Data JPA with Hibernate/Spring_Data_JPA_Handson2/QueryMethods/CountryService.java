package com.cognizant.ormlearn;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Transactional
    public List<Country> searchCountries(String text) {
        return countryRepository.findByNameContaining(text);
    }
    @Transactional
    public List<Country> searchCountriesSorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }
    @Transactional
    public List<Country> searchCountriesStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }
}
