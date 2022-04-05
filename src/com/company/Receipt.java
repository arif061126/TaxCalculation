package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * receipt contains list of shopping products, total tax and price
 */

public class Receipt {
    private List<Product> products = new ArrayList<>();
    private double totalTax = 0.0;
    private double totalProductPrice = 0.0;

    //getter method
    public List<Product> getProducts() {
        return products;
    }

    //setter method
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /*
     * to print customer receipt
     */
    public void printReceipt(){

        //for currency formatter
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        for(Product product:products){
            if (product.getProductQuantity()!=0) {
                System.out.println(product.getProductQuantity() + " " + product.getProductName() +
                        " at " + formatter.format(product.getProductPrice()));
            }else {
                System.out.println("Product");
            }

            //listing total tax according to product category:
            totalTax += product.getProductTax(); //

            //listing total price according to product category:
            totalProductPrice += product.getProductPrice(); //
        }

        System.out.println();
        System.out.println("------------------------------------------");

        //print out product tax according to product category
        System.out.println("Sales Tax: "+formatter.format(totalTax));

        //print out product tax according to product category
        System.out.println("Total: "+formatter.format(totalProductPrice));
    }

}
