package leetcode.easy;

public class RangeSumQuery {
    //https://leetcode.com/problems/range-sum-query-immutable/discuss/75192/Java-simple-O(n)-init-and-O(1)-query-solution
    int[] sum;

    public RangeSumQuery(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

    }

    public int sumRange(int left, int right) {
        if (left == 0) return sum[right];
        return sum[right] - sum[left - 1];
    }
}
