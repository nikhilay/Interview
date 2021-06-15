package leetcode.medium;

public class MaximumProductSubarray {
    //https://www.youtube.com/watch?v=lXVy6YWFcRM&ab_channel=NeetCode
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max_so_far;
            max_so_far = Math.max(nums[i], Math.max(max_so_far * nums[i], min_so_far * nums[i]));
            min_so_far = Math.min(nums[i], Math.min(min_so_far * nums[i], temp * nums[i]));
            result = Math.max(result, max_so_far);
        }
        return result;

    }
}
