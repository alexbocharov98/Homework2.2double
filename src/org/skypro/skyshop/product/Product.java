package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int productPrice;

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

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

}