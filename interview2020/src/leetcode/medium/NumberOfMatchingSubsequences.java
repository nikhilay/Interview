package leetcode.medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class NumberOfMatchingSubsequences {
    //https://leetcode.com/problems/number-of-matching-subsequences/discuss/117598/Java-solution-using-HashMap-and-Queue
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, Deque<String>> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, new LinkedList<>());
        }
        for (String word : words) {
            char c = word.charAt(0);
            if (map.containsKey(c)) {
                map.get(c).addLast(word);
            }
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            Deque<String> list = map.get(c);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String word = list.removeFirst();
                if (word.length() == 1) {
                    // we are removing but, not adding again. So, we would not these single letter word again
                    count++;
                } else {
                    if (map.containsKey(word.charAt(1))) {
                        map.get(word.charAt(1)).addLast(word.substring(1));
                    }
                }

            }
        }
        return count;
    }
}
