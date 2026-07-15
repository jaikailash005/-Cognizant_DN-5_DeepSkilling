package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {

        return service.saveOrder(order);

    }

    @GetMapping
    public List<Order> getOrders() {

        return service.getAllOrders();

    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {

        return service.getOrder(id);

    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {

        service.deleteOrder(id);

        return "Order Deleted Successfully";

    }

}