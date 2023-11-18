package com.example.furnitureworld;

public class Furniture {
    private String userId;
    private String productName;
    private String description;
    private String condition;
    private String price;
    private String address;

    // Default constructor (needed for Firebase)
    public Furniture() {
        // Default constructor required for calls to DataSnapshot.getValue(Furniture.class)
    }

    // Constructor
    public Furniture(String userId, String productName, String description, String condition, String price, String address) {
        this.userId = userId;
        this.productName = productName;
        this.description = description;
        this.condition = condition;
        this.price = price;
        this.address = address;
    }

    // Getters and setters (needed for Firebase)

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}