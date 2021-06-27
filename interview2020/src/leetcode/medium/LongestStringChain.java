package leetcode.medium;

import java.util.*;

public class LongestStringChain {
    //https://leetcode.com/problems/longest-string-chain/solution/
    public int longestStrChain(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();
        int result = 0;
        Collections.addAll(wordsSet, words);
        for (String word : words) {
            result = Math.max(dfs(word, wordsSet, memo), result);
        }
        return result;
    }

    private int dfs(String word, Set<String> wordsSet, Map<String, Integer> memo) {

        if (memo.containsKey(word)) return memo.get(word);
        StringBuilder sb = new StringBuilder(word);
        int maxLen = 1;
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            if(wordsSet.contains(sb.toString())) {
                int curLen = 1 + dfs(sb.toString(), wordsSet, memo);
                maxLen = Math.max(curLen, maxLen);
            }
            sb.insert(i, word.charAt(i));
        }
        memo.put(word, maxLen);
        return memo.get(word);
    }
}
