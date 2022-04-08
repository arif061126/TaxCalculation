package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CalculatePriceAndTaxImpl implements CalculatePriceAndTax{
    /**
     * Single product: to work with
     */
    private final Product product;

    //parameterized constructor
    public CalculatePriceAndTaxImpl(Product product) {
        this.product = product;
    }

    //Statically fixed products are added
    static List<Product> selectedProduct = new ArrayList<>();

    //adding products to list
    static {
        selectedProduct.add(new Product(0, "book", ProductCategory.Basic, new BigDecimal(12.49), 1));
        selectedProduct.add(new Product(1, "music CD", ProductCategory.Luxury, new BigDecimal(14.99), 1));
        selectedProduct.add(new Product(2, "chocolate bar", ProductCategory.Basic, new BigDecimal(0.85), 1));
        selectedProduct.add(new Product(3, "imported box of chocolates", ProductCategory.ImportedBasic, new BigDecimal(10.00), 1));
        selectedProduct.add(new Product(4, "imported bottle of perfume", ProductCategory.ImportedLuxury, new BigDecimal(47.50), 1));
        selectedProduct.add(new Product(5, "imported bottle of perfume", ProductCategory.ImportedLuxury, new BigDecimal(27.99), 1));
        selectedProduct.add(new Product(6, "bottle of perfume", ProductCategory.Luxury, new BigDecimal(18.99), 1));
        selectedProduct.add(new Product(7, "packet of headache pills", ProductCategory.Basic, new BigDecimal(9.75), 1));
        selectedProduct.add(new Product(8, "box of imported chocolates", ProductCategory.ImportedBasic, new BigDecimal(11.25), 1));
    }

    /*
     * calculation of tax according to: product category (product price X product quantity X tax rate)
     *  * 1) Basic- no tax
     *  * 2) Luxury- 10% tax
     *  * 3) ImportedBasic- 5% tax
     *  * 4) ImportedLuxury- 15%  tax
     */

    @Override
    public void calculateTax() {
        switch (product.getProductCategory()){
            case Basic:
                product.setProductTax(BigDecimal.valueOf(0.0));
                break;
            case Luxury:
                product.setProductTax(product.getProductPrice()
                        .multiply(BigDecimal.valueOf(product.getProductQuantity())
                                .multiply(BigDecimal.valueOf(0.10))));
                break;
            case ImportedBasic:
                product.setProductTax(product.getProductPrice()
                        .multiply(BigDecimal.valueOf(product.getProductQuantity())
                                .multiply(BigDecimal.valueOf(0.05))));
                //product.setProductTax(product.getProductPrice() * product.getProductQuantity() * 0.05);
                break;
            case ImportedLuxury:
                product.setProductTax(product.getProductPrice()
                        .multiply(BigDecimal.valueOf(product.getProductQuantity())
                                .multiply(BigDecimal.valueOf(0.15))));
                //product.setProductTax(product.getProductPrice() * product.getProductQuantity() * 0.15);
                break;
            default:
                System.out.println("Out of category....");
        }
    }

    /*
     * Calculates product price (tax incl)
     * @throws ParseException
     */

    @Override
    public void calculateProductPrice() throws ParseException {
        //first to calculate product tax: call calculateTax() method
        calculateTax();

        //for round up decimal value
        //DecimalFormat f = new DecimalFormat("##.00");

        //calculate price:
        //product.setProductPrice((Double) f.parse(f.format((product.getProductPrice()
        //        * product.getProductQuantity()) + product.getProductTax())));

        product.setProductPrice(((product.getProductPrice()
                .multiply(BigDecimal.valueOf(product.getProductQuantity())))
                .add(product.getProductTax())).setScale(2,BigDecimal.ROUND_HALF_UP));
    }
}
