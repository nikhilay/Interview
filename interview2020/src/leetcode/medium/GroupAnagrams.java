package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
//https://leetcode.com/problems/group-anagrams/solution/
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = null;
        if (strs == null || strs.length == 0) return result;
        Map<String, List<String>> memo = new HashMap<>();
        result = new LinkedList<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();
            if (!memo.containsKey(key)) memo.put(key, new LinkedList<>());
            memo.get(key).add(s);
        }
        result.addAll(memo.values());
        return result;
    }
}
