package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserClient userClient;

    public Order saveOrder(Order order) {

        UserDTO user = userClient.getUser(order.getUserId());

        if (user == null) {
            throw new RuntimeException("User Not Found");
        }

        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrder(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

}