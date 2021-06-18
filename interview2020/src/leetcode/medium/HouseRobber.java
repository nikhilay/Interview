package leetcode.medium;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        if (nums.length == 1) return memo[0];
        memo[1] = memo[0] > nums[1] ? memo[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {
            int val = nums[i];
            memo[i] = Math.max(memo[i - 2] + val, memo[i - 1]);
        }

        return memo[nums.length - 1];
    }
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] memo = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 2] = Math.max(memo[i ] + val, memo[i + 1]);
        }

        return memo[memo.length -1 ];
    }
}
