package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String productName, int basePrice, int discountPercent) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getProductPrice() {
        int discountedPrice = basePrice * (100 - discountPercent) / 100;
        return discountedPrice;
    }
    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}