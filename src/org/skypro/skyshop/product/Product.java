package org.skypro.skyshop.product;

public class Product {
    private final String productName;
    private final int productPrice;

    public Product(String productName1, int productPrice1) {
        this.productName = productName1;
        this.productPrice = productPrice1;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }



}