package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

        // Товары
        SimpleProduct mouse = new SimpleProduct("Мышь", 1500);
        DiscountedProduct laptop = new DiscountedProduct("Ноутбук", 50000, 10);
        FixPriceProduct caseProduct = new FixPriceProduct("Чехол");

        searchEngine.add(mouse);
        searchEngine.add(laptop);
        searchEngine.add(caseProduct);

        // Статьи
        Article article1 = new Article("Обзор мыши", "Это обзор игровой мыши с подсветкой.");
        Article article2 = new Article("Преимущества ноутбука", "Рассмотрим преимущества современного ноутбука.");
        Article article3 = new Article("Как выбрать чехол", "Руководство по выбору чехла для телефона.");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        // Поиск
        printSearchResults(searchEngine.search("мышь"));
        printSearchResults(searchEngine.search("ноутбук"));
        printSearchResults(searchEngine.search("чехол"));
        printSearchResults(searchEngine.search("обзор"));
        printSearchResults(searchEngine.search("преимущества"));
    }

    private static void printSearchResults(Searchable[] results) {
        System.out.println("Результаты поиска:");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
        System.out.println();
    }
}