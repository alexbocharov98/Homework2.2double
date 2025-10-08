package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items;

    public SearchEngine() {
        items = new ArrayList<>();
    }

    public void add(Searchable item) {
        items.add(item);
    }

    public List<Searchable> search(String term) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().contains(term)) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxRepeats = 0;
        for (Searchable item : items) {
            int repeats = countOccurrences(item.getSearchTerm(), search);
            if (repeats > maxRepeats) {
                maxRepeats = repeats;
                bestMatch = item;
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