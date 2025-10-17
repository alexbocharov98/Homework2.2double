package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    private final Set<Searchable> items;

    public SearchEngine() {
        items = new HashSet<>();
    }

    public void add(Searchable item) {
        items.add(item);
    }

    public SortedSet<Searchable> search(String term) {
        SortedSet<Searchable> results = new TreeSet<>(new SearchableComparator());
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


    private static class SearchableComparator implements Comparator<Searchable> {
        public int compare(Searchable o1, Searchable o2) {
            int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return o1.getName().compareTo(o2.getName());
        }
    }
}