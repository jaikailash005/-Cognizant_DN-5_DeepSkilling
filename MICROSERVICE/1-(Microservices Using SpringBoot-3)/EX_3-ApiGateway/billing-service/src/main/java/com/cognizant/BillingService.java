package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    private BillRepository repository;

    public Bill saveBill(Bill bill) {
        return repository.save(bill);
    }

    public List<Bill> getAllBills() {
        return repository.findAll();
    }

    public Bill getBill(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteBill(Long id) {
        repository.deleteById(id);
    }

}