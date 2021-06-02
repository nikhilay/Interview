package leetcode.medium;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0) return result;

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right =1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = right * result[i];
            right *=nums[i];
        }
        return result;
    }
}
