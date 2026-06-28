package com.cognizant.ormlearn;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCodeAndDateBetween(String code,LocalDate startDate, LocalDate endDate);
    List<Stock> findByCodeAndCloseGreaterThan(String code,double close);
    List<Stock> findTop3ByOrderByVolumeDesc();
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
