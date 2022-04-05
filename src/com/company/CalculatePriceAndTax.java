package com.company;

import java.text.ParseException;

public interface CalculatePriceAndTax {

    //to calculate sale taxes according to category
    void calculateTax();

    /*
     * to calculate product price according to category
     * @throws ParseException
     */
    void calculateProductPrice() throws ParseException;
}
