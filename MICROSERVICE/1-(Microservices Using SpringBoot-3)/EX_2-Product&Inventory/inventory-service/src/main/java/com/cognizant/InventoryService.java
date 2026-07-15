package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    @Autowired
    private ProductClient productClient;

    public Inventory save(Inventory inventory) {

        ProductDTO product = productClient.getProduct(inventory.getProductId());

        if (product == null) {
            throw new RuntimeException("Product Not Found");
        }

        return repository.save(inventory);
    }

    public List<Inventory> getAll() {
        return repository.findAll();
    }
}