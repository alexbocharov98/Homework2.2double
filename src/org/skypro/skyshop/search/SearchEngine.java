package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int count = 0;

    public SearchEngine(int size) {
        items = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("Добавить элемент невозможно");
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultsCount = 0;

        for (int i = 0; i < count; i++) {
            if (items[i].getSearchTerm().contains(term)) {
                results[resultsCount++] = items[i];
                if (resultsCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}