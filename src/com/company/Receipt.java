package com.company;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * receipt contains list of shopping products, total tax and price
 */

public class Receipt {
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalTax = BigDecimal.valueOf(0.0);
    private BigDecimal totalProductPrice = BigDecimal.valueOf(0.0);

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
            System.out.println( product.getProductQuantity() != 0 ? product.getProductQuantity()
                    + " " + product.getProductName() + " at " + formatter.format((product.getProductPrice())
                    .setScale(3,BigDecimal.ROUND_HALF_UP)) : "Product Quantity can not be 0!");


            //listing total tax according to product category:
            //totalTax += product.getProductTax(); //
            totalTax = (totalTax.add(product.getProductTax())).setScale(1,BigDecimal.ROUND_HALF_UP);

            //listing total price according to product category:
            //totalProductPrice += product.getProductPrice(); //
            totalProductPrice = (totalProductPrice.add(product.getProductPrice())).setScale(1,BigDecimal.ROUND_HALF_UP);
        }

        System.out.println();
        System.out.println("------------------------------------------");

        //print out product tax according to product category
        System.out.println("Sales Tax: "+formatter.format(totalTax));

        //print out product tax according to product category
        System.out.println("Total: "+formatter.format(totalProductPrice));
    }

}
