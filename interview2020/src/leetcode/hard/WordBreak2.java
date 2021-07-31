package leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<>();
        if (wordDict == null || wordDict.size() == 0) return result;
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        helper(set, s,0, new StringBuilder(),  result);
        return result;
    }

    private void helper(HashSet<String> set, String word,
                        int index, StringBuilder result, List<String> results) {
        if (index == word.length()) {
            results.add(result.toString().trim());
            return;
        }
        StringBuilder sb = new StringBuilder();
        int size = result.length();
        for (int i = index; i < word.length(); i++) {
            sb.append(word.charAt(i));
            if (set.contains(sb.toString())) {
                result.append(sb.toString()).append(" ");
                helper(set, word, i + 1, result, results);
                result.delete(size,result.length());
            }

        }
    }
}
