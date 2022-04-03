package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @author Arif Ahmed
 * first step to solve this problem:
 * create a class: with properties: id, name, category, price, quantity and tax
 */

public class Products {
    //unique id for each product
    private int productId;
    //Product Name: String
    private String productName;
    //Product Category: enum
    private ProductCategory productCategory;
    //Product price: double
    private Double productPrice;
    //Product Quantity: int
    private int productQuantity;
    //Product Tax: double
    private Double productTax;

    //default constructor
    public Products() {
    }

    //constructor with all properties
    public Products(int productId, String productName, ProductCategory productCategory, Double productPrice, int productQuantity, Double productTax) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productTax = productTax;
    }

    //constructor except tax


    public Products(int productId, String productName, ProductCategory productCategory, Double productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

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

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductTax() {
        return productTax;
    }

    public void setProductTax(Double productTax) {
        this.productTax = productTax;
    }

    /**
     * calculation of tax according to: product category (product price X product quantity X tax rate)
     *  * 1) Basic- no tax
     *  * 2) Luxury- 10% tax
     *  * 3) ImportedBasic- 5% tax
     *  * 4) ImportedLuxury- 15%  tax
     */

    //for currency formatter
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    //for round up decimal value
    DecimalFormat f = new DecimalFormat("##.00");

    public void calculateTax(){
        switch (this.productCategory){
            case Basic:
                this.productTax = 0.0;
                break;
            case Luxury:
                this.productTax = this.productPrice * this.productQuantity * 0.10;
                break;
            case ImportedBasic:
                this.productTax = this.productPrice * this.productQuantity * 0.05;
                break;
            case ImportedLuxury:
                this.productTax = this.productPrice * this.productQuantity * 0.15;
                break;
            default:
                System.out.println("Out of category....");
        }
    }

        /**
         * calculation of product price according to product category:
         * product price = product price + (product price X product quantity X tax rate)
         */

        //commit: throws exception because of using formatting to round up double
        public double calculateProductPrice () throws ParseException {
            //first to calculate product tax: call calculateTax() method
            calculateTax();
            //calculate price:
            this.productPrice = (Double) f.parse(f.format((this.productPrice * this.productQuantity) + this.productTax));
            return this.productPrice;
        }


        /**
         * this is to show product with price
         * helps customers to select products from the list
         */

        public void showProductWithPrice(){
            System.out.println("Press "+this.productId + " : to select "+ this.productName + " > unit price: "+ formatter.format(productPrice)); //commit: this.productPrice to productPrice
        }

        /**
         * to print customer receipt
         */

        public String printCustomerReceipt(){
            return (this.productQuantity !=0 ? (String.valueOf(this.productQuantity) +" "+ this.productName + " at "+String.valueOf(formatter.format(this.productPrice))) : "" ); //commit: add formatter
        }
    }

    /**
     * need to create a list to print out this receipt
     */

