package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    private static final Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public static int getTotalPrice() {
        int total = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                total += product.getProductPrice();
            }
        }
        return total;
    }

    public static void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean hasProduct(String productName) {
        List<Product> products = basket.get(productName);
        return products != null && !products.isEmpty();
    }

    public void cleanBasket() {
        basket.clear();
    }

    public static List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = basket.remove(name);
        if (removedProducts == null) {
            return new ArrayList<>(); // Возвращаем пустой список, если продукта нет
        }
        return removedProducts;
    }
}