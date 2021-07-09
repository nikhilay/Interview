package leetcode.medium;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    //https://leetcode.com/problems/minimum-increment-to-make-array-unique/discuss/197713/C%2B%2B-concise-solution-O(nlogn)-complexity-with-explanation-and-example-step-by-step
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int diff = nums[i-1] + 1 - nums[i];
                nums[i] = nums[i-1] + 1;
                res+=diff;
            }

        }
        return res;
    }
}
