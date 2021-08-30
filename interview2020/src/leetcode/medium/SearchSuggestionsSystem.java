package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
    //https://leetcode.com/problems/search-suggestions-system/solution/
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new LinkedList<>();
        StringBuilder prefix = new StringBuilder();
        int len = products.length;
        int searchStart = 0;
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            String prefixString = prefix.toString();
            int start = lowerBound(products, prefixString, searchStart);
            result.add(new LinkedList<>());
            for (int i = start; i < Math.min(start + 3, len); i++) {
                if (products[i].length() >= prefix.length() && products[i].startsWith(prefixString)) {
                    result.get(result.size() - 1).add(products[i]);
                }
            }

        }
        return result;
    }

    // ["mobile", "moneypot","monitor", "mouse", "mousepad"]
    private int lowerBound(String[] products, String prefix, int searchStart) {
        int start = searchStart;
        int end = products.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (products[mid].compareTo(prefix) >= 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

    return start;
    }
}
