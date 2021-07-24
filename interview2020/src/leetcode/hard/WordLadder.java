package leetcode.hard;

import java.util.*;

public class WordLadder {
    //https://leetcode.com/problems/word-ladder/discuss/40707/C++-BFS/38513
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hashSet = new HashSet<>(wordList);
        if (!hashSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();

        for (int len = 1; !queue.isEmpty(); len++) {
            for (int q = queue.size(); q > 0; q--) {
                String word = queue.poll();
                if (endWord.equals(word)) return len;
                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = String.valueOf(arr);
                        if (hashSet.contains(newWord) && visited.add(newWord)) queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
