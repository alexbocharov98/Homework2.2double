package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.SortedSet;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        // Добавляем продукты
        searchEngine.add(new SimpleProduct("Мышь", 1500));
        searchEngine.add(new DiscountedProduct("Ноутбук", 50000, 10));
        searchEngine.add(new FixPriceProduct("Чехол"));

        // Добавляем статьи
        searchEngine.add(new Article("Обзор мыши", "Обзор игровой мыши с подсветкой"));
        searchEngine.add(new Article("Преимущества ноутбука", "Все преимущества современного ноутбука"));
        searchEngine.add(new Article("Выбор чехла", "Как выбрать чехол для телефона"));

        // Поиск по запросу "ноутбук"
        System.out.println("Поиск по запросу 'ноутбук':");
        SortedSet<Searchable> results = searchEngine.search("ноутбук");
        if (results.isEmpty()) {
            System.out.println("Результаты не найдены.");
        } else {
            for (Searchable item : results) {
                System.out.println(item.getStringRepresentation());
            }
        }
        System.out.println();

        // Поиск по запросу "чехол"
        System.out.println("Поиск по запросу 'чехол':");
        results = searchEngine.search("чехол");
        if (results.isEmpty()) {
            System.out.println("Результаты не найдены.");
        } else {
            for (Searchable item : results) {
                System.out.println(item.getStringRepresentation());
            }
        }
        System.out.println();

        // Поиск наиболее подходящего результата с обработкой исключения
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