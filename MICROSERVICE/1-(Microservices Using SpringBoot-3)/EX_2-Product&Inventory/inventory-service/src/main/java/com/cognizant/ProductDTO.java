package com.cognizant;

public class ProductDTO {

    private Long id;
    private String productName;
    private int stock;

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}