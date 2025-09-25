package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;

public class App {
    public static void main(String[] args) {
           SearchEngine searchEngine = new SearchEngine(10);

            // Добавляем товары
            searchEngine.add(new SimpleProduct("Мышь", 1500));
            searchEngine.add(new DiscountedProduct("Ноутбук", 50000, 10));
            searchEngine.add(new FixPriceProduct("Чехол"));

            // Добавляем статьи
            searchEngine.add(new Article("Обзор мыши", "Обзор игровой мыши с подсветкой."));
            searchEngine.add(new Article("Преимущества ноутбука", "Все преимущества современного ноутбука."));

            // Ситуация 1: Объект существует в массиве
            try {
                Searchable bestMatch = searchEngine.findBestMatch("мышь");
                System.out.println("Лучший результат по запросу 'мышь': " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            // Ситуация 2: Объект не найден, выбрасывается исключение
            try {
                Searchable bestMatch = searchEngine.findBestMatch("принтер");
                System.out.println("Лучший результат по запросу 'принтер': " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

    }
