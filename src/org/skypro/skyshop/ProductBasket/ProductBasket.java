package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private static final List<Product> basket = new ArrayList<>();

    public void addProduct(Product product) {
        basket.add(product);
    }

    public static int getTotalPrice() {
        int result = 0;
        for (Product product : basket) {
            result += product.getProductPrice();
        }
        return result;
    }

    public static void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : basket) {
                System.out.println(product.toString());
            }
            System.out.println("Итого: " + getTotalPrice());
        }
    }

    public boolean hasProduct(String productName) {
        for (Product product : basket) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        basket.clear();
    }

    public static List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}

