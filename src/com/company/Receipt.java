package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * receipt contains list of shopping products, total tax and price
 */

public class Receipt {
    List<Product> products = new ArrayList<>();
    double totalTax = 0.0;
    double totalProductPrice = 0.0;

    //for currency formatter
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void printReceipt(){
        for(Product product:products){
            if (product.getProductQuantity() != 0) {
                System.out.println(product.getProductQuantity() + " " + product.getProductName() + " at " + formatter.format(product.getProductPrice()));
            } else {
                System.out.println("Product quantity can not be 0");
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
