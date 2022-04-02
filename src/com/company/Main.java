package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * To solve this problem: what is needed:
 * 1) To print out receipt which contain:
 * - different products with name, category, price, quantity and tax
 * 2) Calculation of sales tax according to category
 * 3) Calculation of price according to category
 * 4) Calculation of total price
 *
 */


public class Main {

    public static void main(String[] args) {
        List<Products> products = new ArrayList<>();

        //adding products to list
        products.add(new Products(0,"book", ProductCategory.Basic, 12.49,1));
        products.add(new Products(1,"music CD", ProductCategory.Luxury, 14.99,1));
        products.add(new Products(2,"chocolate bar", ProductCategory.Basic, 0.85,1));
        products.add(new Products(3,"imported box of chocolates", ProductCategory.ImportedBasic, 10.00,1));
        products.add(new Products(4,"imported bottle of perfume", ProductCategory.ImportedLuxury, 47.50,1));
        products.add(new Products(5,"imported bottle of perfume", ProductCategory.ImportedLuxury, 27.99,1));
        products.add(new Products(6,"bottle of perfume", ProductCategory.ImportedLuxury, 18.99,1));
        products.add(new Products(7,"packet of headache pills", ProductCategory.Basic, 9.75,1));
        products.add(new Products(8,"box of imported chocolates", ProductCategory.ImportedBasic, 11.25,1));

        //Error handling with try catch block
        try{
            // User input
            Scanner scanner = new Scanner(System.in);

            Receipt receipt = new Receipt();

            System.out.println();
            System.out.println("Please select the items from the following list:");

            //print out the product list with price
            for(Products p:products){
                p.showProductWithPrice();
            }

            //for select product from the product list by product id
            System.out.println();
            System.out.println("Enter product Id: ");
            int selectedProductId = scanner.nextInt();

            // for input product quantity:
            System.out.println("Enter product quantity: ");
            int selectedProductQuantity = scanner.nextInt();

            //selected product by id
            Products selectedProduct = products.get(selectedProductId);

            //setting selected product quantity
            selectedProduct.setProductQuantity(selectedProductQuantity);

            //calculate price for the selected product
            selectedProduct.calculateProductPrice();

            //add the selected product to the list of receipt
            receipt.products.add(selectedProduct);

            //printing the receipt
            receipt.printReceipt();
        }catch (Exception e){
            //printing out error message
            System.out.println(e.getMessage()+", you are getting error!");
            //printing out type of error
            System.out.println("Error type: "+e.getClass());
            //printing out feedback message
            System.out.println("Something went wrong. Please Try again!");
        }

    }
}
