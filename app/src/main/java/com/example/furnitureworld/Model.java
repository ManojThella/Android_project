package com.example.furnitureworld;
public class Model {
    private String productName;
    private String description;
    // Add more fields as needed

    // Empty constructor required for Firebase
    public Model() {
    }

    // Parameterized constructor
    public Model(String productName, String description) {
        this.productName = productName;
        this.description = description;
        // Initialize additional fields as needed
    }

    // Getter and setter methods

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

    // Add getter and setter methods for additional fields

}

