package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] basket = new Product[5];
    private int count = 0;

    public void addProduct(Product product) {
        if (count >= basket.length) {
            System.out.println("Невозможно добавить продукт");
        } else {
            basket[count++] = product;
        }
    }
    public int getTotalPrice() {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result = result + basket[i].getProductPrice();
        }
        return result;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("в корзине пусто");
        } else {
            for (int i = 0; i < basket.length; i++) {
                System.out.println(basket[i].getProductName() + ": " + basket[i].getProductPrice());
            }
            System.out.println("Итого: " + getTotalPrice());
        }

    }

    public boolean hasProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (basket[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
        count = 0;
    }
}

