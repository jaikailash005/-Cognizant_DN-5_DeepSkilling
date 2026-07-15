package com.cognizant;

import jakarta.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private int stock;

    public Inventory() {
    }

    public Inventory(Long id, Long productId, int stock) {
        this.id = id;
        this.productId = productId;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}