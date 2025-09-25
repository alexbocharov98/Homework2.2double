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
            System.out.println("Массив заполнен. Добавить невозможно.");
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


    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxRepeats = 0;

        for (int i = 0; i < count; i++) {
            int repeats = countOccurrences(items[i].getSearchTerm(), search);
            if (repeats > maxRepeats) {
                maxRepeats = repeats;
                bestMatch = items[i];
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

        private int countOccurrences(String str, String subStr) {
        if (subStr.isEmpty()) {
            return 0;
        }
        int count = 0;
        int fromIndex = 0;

        while ((fromIndex = str.indexOf(subStr, fromIndex)) != -1) {
            count++;
            fromIndex += subStr.length();
        }
        return count;
    }
}