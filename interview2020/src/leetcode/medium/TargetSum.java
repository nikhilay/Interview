package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    //https://leetcode.com/problems/target-sum/discuss/169648/Java-DFS-and-Memorization-with-Explanations
    //https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums, 0, target, 0, memo);

    }

    private int helper(int[] nums, int index, int target, int currSum, Map<String, Integer> memo) {
        if (memo.containsKey(index + ":" + currSum)) return memo.get(index + ":" + currSum);
        if (index == nums.length && currSum == target) return 1;
        if (index == nums.length) return 0;

        int noOfWaysPositive = helper(nums, index + 1, target, currSum + nums[index], memo);
        int noOfWaysNegative = helper(nums, index + 1, target, currSum - nums[index], memo);
        int totalWays = noOfWaysPositive + noOfWaysNegative;

        memo.put(index + ":" + currSum, totalWays);
        return totalWays;
    }
}
