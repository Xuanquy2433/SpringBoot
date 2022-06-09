package com.example.asm.dto;

public class CartDto {
    private int productId;
    private Double price;
    private String name;
    private int quantity;
    private String image;

    public CartDto() {
    }

    public CartDto(int productId, Double price, String name, int quantity, String image) {
        this.productId = productId;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
