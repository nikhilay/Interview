package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        if (words == null) return "";
        Arrays.sort(words);
        Set<String> hashSet = new HashSet<>();
        String result = "";
        for (String w : words) {

            if (w.length() == 1 || hashSet.contains(w.substring(0, w.length() - 1))) {
                result = w.length() > result.length() ? w : result;
                hashSet.add(w);
            }

        }
        return result;
    }
}
