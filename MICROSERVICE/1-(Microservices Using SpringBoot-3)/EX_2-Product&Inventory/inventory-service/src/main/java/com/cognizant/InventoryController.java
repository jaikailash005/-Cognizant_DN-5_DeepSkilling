package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return service.save(inventory);
    }

    @GetMapping
    public List<Inventory> getInventory() {
        return service.getAll();
    }
}