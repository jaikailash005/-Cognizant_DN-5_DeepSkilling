package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService service;

    @PostMapping
    public Bill addBill(@RequestBody Bill bill) {
        return service.saveBill(bill);
    }

    @GetMapping
    public List<Bill> getBills() {
        return service.getAllBills();
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id) {
        return service.getBill(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        service.deleteBill(id);
        return "Bill Deleted Successfully";
    }

}