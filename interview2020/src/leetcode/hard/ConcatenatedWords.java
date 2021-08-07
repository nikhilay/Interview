package leetcode.hard;

import java.util.*;

public class ConcatenatedWords {
    //https://leetcode.com/problems/concatenated-words/discuss/95652/Java-DP-Solution
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new LinkedList<>();
        if (words == null || words.length == 0) return result;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() -o2.length();
            }
        });
        HashSet<String> dict = new HashSet<>();

        for (String word : words) {

            if (canForm(word, dict)) {
                result.add(word);
            }
            dict.add(word);
        }
        return result;
    }

    private boolean canForm(String word, Set<String> dict) {
        if(dict.isEmpty()) return false;
        boolean[] memo = new boolean[word.length() + 1];
        memo[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && dict.contains(word.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[word.length()];

    }
}
