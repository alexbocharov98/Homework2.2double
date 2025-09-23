package org.skypro.skyshop.product;

public abstract class Product {
    private String productName;


    public Product(String productName1) {
        this.productName = productName1;

    }


    public String getProductName() {
        return productName;
    }
    public abstract int getProductPrice();

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice();
    }

    public boolean isSpecial() {
        return false;
    }


    }


