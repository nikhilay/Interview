package leetcode.medium;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    //https://leetcode.com/problems/longest-increasing-subsequence/solution/
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > result.get(result.size() - 1)) {
                result.add(nums[i]);
            } else {
                int j = search(result, nums[i]);
                result.set(j, nums[i]);
            }
        }
        return result.size();

    }

    private int search(ArrayList<Integer> result, int n) {
        int start = 0;
        int end = result.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (result.get(mid) == n) {
                return mid;
            } else if (result.get(mid) > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
