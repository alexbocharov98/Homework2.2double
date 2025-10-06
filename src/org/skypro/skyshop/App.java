package org.skypro.skyshop;

import org.skypro.skyshop.ProductBasket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


import java.util.List;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        // Добавление товаров и статей (пример):
        searchEngine.add(new SimpleProduct("Мышь", 1500));
        searchEngine.add(new DiscountedProduct("Ноутбук", 50000, 10));
        searchEngine.add(new FixPriceProduct("Чехол"));
        searchEngine.add(new Article("Обзор мыши", "Обзор игровой мыши с подсветкой."));
        searchEngine.add(new Article("Преимущества ноутбука", "Все преимущества современного ноутбука."));

        System.out.println("Поиск по запросу 'ноутбук':");
        List<Searchable> results = searchEngine.search("ноутбук");
        if (results.isEmpty()) {
            System.out.println("Результаты не найдены.");
        } else {
            for (Searchable item : results) {
                System.out.println(item.getStringRepresentation());
            }

            System.out.println("Содержимое корзины до удаления:");
            ProductBasket.printBasket();

            // Удаляем существующий продукт "Мышь"
            List<Product> removed = ProductBasket.removeProductsByName("Мышь");
            System.out.println("\nУдаленные продукты:");
            if (removed.isEmpty()) {
                System.out.println("Список пуст");
            } else {
                for (Product product : removed) {
                    System.out.println(product.toString());
                }
            }

            System.out.println("\nСодержимое корзины после удаления продуктов \"Мышь\":");
            ProductBasket.printBasket();

            // Пробуем удалить несуществующий продукт "Принтер"
            List<Product> removed2 = ProductBasket.removeProductsByName("Принтер");
            System.out.println("\nПопытка удалить несуществующий продукт \"Принтер\":");

            if (removed2.isEmpty()) {
                System.out.println("Список пуст");
            }

            System.out.println("Содержимое корзины в конце:");
            ProductBasket.printBasket();
        }

    }
}
