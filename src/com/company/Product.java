package com.company;

/**
 * @author Arif Ahmed
 * first step to solve this problem:
 * create a class: with properties: id, name, category, price, quantity and tax
 */

public class Product {
    //unique id for each product
    private int productId;

    //Product Name: String
    private String productName;

    //Product Category: enum
    private ProductCategory productCategory;

    //Product price: double
    private double productPrice;

    //Product Quantity: int
    private int productQuantity;

    //Product Tax: double
    private double productTax;

    //constructor except tax
    public Product(int productId, String productName, ProductCategory productCategory, double productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product(){}

    //getter and setters:
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductTax() {
        return productTax;
    }

    public void setProductTax(double productTax) {
        this.productTax = productTax;
    }

}

/*
 * need to create a list to print out this receipt
 */
