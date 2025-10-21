package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private Map<String, List<Product>> products;


    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }


    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        products.values().stream()
                .flatMap(List::stream)
                .forEach(product -> System.out.println(product.toString()));

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Количество специальных продуктов: " + getSpecialCount());
    }


    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }
}