package com.company;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SelectProductList {

    //Statically fixed products are added
    static final List<Product> productList = new ArrayList<>();

    /*
     * adding products to list
     * this is actually list only for product listing
     * for this program only could be used but in that case: every time menu list is updated according to the new product added in the cart
     */

    static {
        productList.add(new Product(0, "book", ProductCategory.Basic, BigDecimal.valueOf(12.49), 1));
        productList.add(new Product(1, "music CD", ProductCategory.Luxury, BigDecimal.valueOf(14.99), 1));
        productList.add(new Product(2, "chocolate bar", ProductCategory.Basic, BigDecimal.valueOf(0.85), 1));
        productList.add(new Product(3, "imported box of chocolates", ProductCategory.ImportedBasic, BigDecimal.valueOf(10.00), 1));
        productList.add(new Product(4, "imported bottle of perfume", ProductCategory.ImportedLuxury, BigDecimal.valueOf(47.50), 1));
        productList.add(new Product(5, "imported bottle of perfume", ProductCategory.ImportedLuxury, BigDecimal.valueOf(27.99), 1));
        productList.add(new Product(6, "bottle of perfume", ProductCategory.Luxury, BigDecimal.valueOf(18.99), 1));
        productList.add(new Product(7, "packet of headache pills", ProductCategory.Basic, BigDecimal.valueOf(9.75), 1));
        productList.add(new Product(8, "box of imported chocolates", ProductCategory.ImportedBasic, BigDecimal.valueOf(11.25), 1));
    }

    /**
     * Show console selection options for user
     * this is to show product with price
     * helps customers to select products from the list
     */
    public void showProductSelection() {
        //for currency formatter
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        for (Product product : productList) {
            System.out.println("Press " + product.getProductId() + " : to select " + product.getProductName() +
                    " > unit price: " + formatter.format(product.getProductPrice()) );
            System.out.println("---------------------------------------------------------------------");
        }
    }
}
