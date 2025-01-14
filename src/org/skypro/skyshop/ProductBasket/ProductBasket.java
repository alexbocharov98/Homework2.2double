package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;

public final class ProductBasket {
    Product[] basket = new Product[5];
    int count = 0;

    public void addProduct(Product product) {
        if (count >= basket.length) {
            System.out.println("Невозможно добавить продукт");
        } else {
            basket[count++] = product;
        }
    }

    public int summ() {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result = result + basket[i].getProductPrice();
        }
        return result;
    }

    public void printing() {
        if (count == 0) {
            System.out.println("в корзине пусто");
        } else {
            for (int i = 0; i < basket.length; i++) {
                System.out.println(basket[i].getProductName() + ": " + basket[i].getProductPrice());
            }
            System.out.println("Итого: " + summ());
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

