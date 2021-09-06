package leetcode.medium;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    //Beautiful explanation
    //https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/discuss/730567/JavaC%2B%2BPython-Straight-Forward
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) return 0;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, nums[n - 1 - i] - nums[3 - i]);
        }
        return result;
    }
}
