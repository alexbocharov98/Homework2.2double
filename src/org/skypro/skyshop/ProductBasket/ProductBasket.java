package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    Product[] arr = new Product[5];
    int pointer = 0;

    public void addProduct(Product product) {
        if (pointer > 4) {
            System.out.println("Невозможно добавить продукт");
        } else {
            arr[pointer] = product;
            pointer = pointer + 1;
        }
    }

    public int summ() {
        int result = 0;
        for (int i = 0; i < pointer; i++) {
            result = result + arr[i].getProductPrice();
        }
        return result;
    }

    public void printing() {
        if (pointer == 0) {
            System.out.println("в корзине пусто");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].getProductName() + ": " + arr[i].getProductPrice());
            }
            System.out.println("Итого: " + summ());
        }

    }

    public boolean hasProduct(String productName) {
        for (int i = 0; i < pointer; i++) {
            if (arr[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
        pointer = 0;
    }
}

