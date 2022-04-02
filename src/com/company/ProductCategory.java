package com.company;

/**
 * this is to define the product category:
 * according to this problem: products fall under following categories:
 * 1) Basic- that exempt tax like book, foods, medicines, etc.
 * 2) Luxury- that contain 10% tax like perfume, etc.
 * 3) ImportedBasic- that contain 5% tax like imported chocolate
 * 4) ImportedLuxury- that contain 15%  tax like imported perfume, etc.
 */

public enum ProductCategory {
    Basic,
    Luxury,
    ImportedBasic,
    ImportedLuxury
}
