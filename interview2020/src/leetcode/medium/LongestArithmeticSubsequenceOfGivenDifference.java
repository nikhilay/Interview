package leetcode.medium;

import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        if (arr == null || arr.length == 0) return max;
        HashMap<Integer, Integer> freq = new HashMap<>();
        //5, 7, 8, 5, 3, 4, 2, 1, 1
        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n - difference, 0) + 1);
            max = Math.max(max, freq.get(n));
        }
        return max;
    }
}
