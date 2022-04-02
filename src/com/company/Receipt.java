package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * receipt contains list of shopping products, total tax and price
 */

public class Receipt {
    List<Products> products = new ArrayList<>();
    double totalTax = 0.0;
    double totalProductPrice = 0.0;

    //for currency formatter
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void printReceipt(){
        for(Products p:products){
            System.out.println(p.printCustomerReceipt());

            //listing total tax according to product category:
            totalTax += p.getProductTax();

            //listing total price according to product category:
            totalProductPrice += p.getProductPrice();
        }
        System.out.println();
        System.out.println("------------------------------------------");
        //print out product tax according to product category
        System.out.println("Sales Tax: "+formatter.format(totalTax));

        //print out product tax according to product category
        System.out.println("Total: "+formatter.format(totalProductPrice));
    }

}
