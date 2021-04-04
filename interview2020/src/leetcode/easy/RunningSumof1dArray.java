package leetcode.easy;

public class RunningSumof1dArray {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        for(int i = 1; i < nums.length ; i++){
            nums[i] += nums[i-1];
        }

        return nums;

    }
}
