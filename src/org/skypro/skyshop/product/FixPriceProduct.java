package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 1000;

    public FixPriceProduct(String productName) {
        super(productName);
    }


    @Override
    public int getProductPrice() {
        return FIXED_PRICE;
    }
    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}