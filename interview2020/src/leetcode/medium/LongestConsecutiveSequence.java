package leetcode.medium;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    //https://leetcode.com/problems/longest-consecutive-sequence/solution/
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> memo = new HashSet<>();
        for (int n : nums) memo.add(n);

        int longestSeq = 0;
        for (int n : nums) {
            if (!memo.contains(n - 1)) {
                int curSeq = 1;
                int m = n + 1;
                while (memo.contains(m)) {
                    m++;
                    curSeq++;
                }
                longestSeq = Math.max(curSeq, longestSeq);
            }
        }
        return longestSeq;

    }
}
