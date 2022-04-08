package com.company;

import java.math.BigDecimal;

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
    private BigDecimal productPrice;

    //Product Quantity: int
    private int productQuantity;

    //Product Tax: double
    private BigDecimal productTax;

    //constructor except tax
    public Product(int productId, String productName, ProductCategory productCategory,
                   BigDecimal productPrice, int productQuantity) {
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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getProductTax() {
        return productTax;
    }

    public void setProductTax(BigDecimal productTax) {
        this.productTax = productTax;
    }

}

/*
 * need to create a list to print out this receipt
 */
