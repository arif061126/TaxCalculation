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
        List<Product> productList = new ArrayList<>();

        //adding productsList to list
        productList.add(new Product(0,"book", ProductCategory.Basic, 12.49,1));
        productList.add(new Product(1,"music CD", ProductCategory.Luxury, 14.99,1));
        productList.add(new Product(2,"chocolate bar", ProductCategory.Basic, 0.85,1));
        productList.add(new Product(3,"imported box of chocolates", ProductCategory.ImportedBasic, 10.00,1));
        productList.add(new Product(4,"imported bottle of perfume", ProductCategory.ImportedLuxury, 47.50,1));
        productList.add(new Product(5,"imported bottle of perfume", ProductCategory.ImportedLuxury, 27.99,1));
        productList.add(new Product(6,"bottle of perfume", ProductCategory.Luxury, 18.99,1));
        productList.add(new Product(7,"packet of headache pills", ProductCategory.Basic, 9.75,1));
        productList.add(new Product(8,"box of imported chocolates", ProductCategory.ImportedBasic, 11.25,1));

        Scanner scanner = new Scanner(System.in);

        //CalculateProductPriceAndTax calculate = new CalculateProductPriceAndTaxImplementation();

        Receipt receipt = new Receipt();

        int selectedProductId = 0;

        //looping through the shopping cart: till end of shopping
        while (selectedProductId < productList.size()){
            //Error handling with try catch block
            try{
                // User input
                System.out.println();
                System.out.println("Please select the items from the following list:");

                //print out the product list with price
                for(Product p: productList){
                    p.showProductWithPrice();
                }

                //to complete shopping:
                System.out.println("press 10 or greater than 10: To complete your shopping.");

                //for select product from the product list by product id
                System.out.println();
                System.out.println("Enter product Id: ");
                selectedProductId = Integer.parseInt(scanner.nextLine());//commit

                //to end up shopping:
                if(selectedProductId> productList.size()){
                    break;
                }

                // for input product quantity:
                System.out.println("Enter product quantity: ");
                int selectedProductQuantity = Integer.parseInt(scanner.nextLine());//commit

                //selected product by id
                Product selectedProduct = productList.get(selectedProductId);

                //setting selected product quantity
                selectedProduct.setProductQuantity(selectedProductQuantity);

                //calculate price for the selected product
                selectedProduct.calculateProductPrice();

                //add the selected product to the list of receipt
                receipt.products.add(selectedProduct);


            }catch (Exception e){
                //printing out error message
                System.out.println(e.getMessage()+", you are getting error!");
                //printing out type of error
                System.out.println("Error type: "+e.getClass());
                //printing out feedback message
                System.out.println("Something went wrong. Please Try again!");
                System.out.println();
            }
        }

        //printing the receipt
        System.out.println();
        System.out.println("<<<<<<<<< YOUR RECEIPT >>>>>>>>>");
        System.out.println();
        receipt.printReceipt();

    }
}
