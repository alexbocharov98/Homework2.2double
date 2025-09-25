package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Поле с названием не может быть пустым");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }


    @Override
    public String getSearchTerm() {
        return getProductName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return getProductName();
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();




}