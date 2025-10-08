package org.skypro.skyshop;

import org.skypro.skyshop.ProductBasket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


import java.util.List;
import java.util.Map;

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
        Map<String, Searchable> results = searchEngine.search("ноутбук");
        if (results.isEmpty()) {
            System.out.println("Результаты не найдены.");
        } else {
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getStringRepresentation());
            }
        }
        System.out.println();

        System.out.println("Поиск по запросу 'чехол':");
        results = searchEngine.search("чехол");
        if (results.isEmpty()) {
            System.out.println("Результаты не найдены.");
        } else {
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getStringRepresentation());
            }
        }
        System.out.println();


        try {
            Searchable bestMatch = searchEngine.findBestMatch("мышь");
            System.out.println("Лучший результат по запросу 'мышь': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            Searchable bestMatch = searchEngine.findBestMatch("принтер");
            System.out.println("Лучший результат по запросу 'принтер': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}