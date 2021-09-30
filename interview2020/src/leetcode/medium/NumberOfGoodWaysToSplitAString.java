package leetcode.medium;

import java.util.HashSet;

public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        char[] array = s.toCharArray();
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        HashSet<Character> hset = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            hset.add(array[i]);
            left[i] = hset.size();
        }

        hset.clear();
        for (int i = array.length - 1; i >= 0; i--) {
            hset.add(array[i]);
            right[i] = hset.size();
        }
        int ways = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (left[i] == right[i + 1]) {
                ways++;
            }

        }
        return ways;
    }
}
