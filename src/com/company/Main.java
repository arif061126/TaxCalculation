package com.company;

import java.util.Scanner;
import static com.company.SelectProductList.*;

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
        //for user input
        Scanner scanner = new Scanner(System.in);

        //CalculatePriceAndTax calculate = new CalculatePriceAndTaxImpl();
        SelectProductList selectProductList = new SelectProductList();

        Receipt receipt = new Receipt();

        int selectedProductId = 0;

        //looping through the shopping cart: till end of shopping
        while (selectedProductId < productList.size()){
            //Error handling with try catch block
            try{
                // User input
                System.out.println();
                System.out.println("Please select the items from the following list:");
                System.out.println("---------------------------------------------------------------------");

                //print out the product list with price
                selectProductList.showProductSelection();

                //to complete shopping:
                System.out.println("press "+productList.size()+" or greater than "+productList.size()+": To complete your shopping."); //commit: make it dynamic

                //for select product from the product list by product id
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Enter product Id: ");
                selectedProductId = Integer.parseInt(scanner.nextLine());//commit

                //to end up shopping:
                if(selectedProductId> productList.size()-1){
                    break;
                }

                // for input product quantity:
                System.out.println("Enter product quantity: ");
                int selectedProductQuantity = Integer.parseInt(scanner.nextLine());//commit

                //selected product by id
                Product selectedProduct = CalculatePriceAndTaxImpl.selectedProduct.get(selectedProductId);

                //setting selected product quantity
                selectedProduct.setProductQuantity(selectedProductQuantity);

                //calculate price for the selected product
                //new CalculatePriceAndTaxImpl().setProduct(selectedProduct);
                new CalculatePriceAndTaxImpl(selectedProduct).calculateProductPrice();
                //add the selected product to the list of receipt
                receipt.getProducts().add(selectedProduct);

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
