package leetcode.easy;

public class MinimumValueToGetPositiveStepbyStepSum {
    //https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/discuss/585560/C%2B%2BJava-O(n)
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;

        for (int i : nums) {
            sum += i;
            minSum = Math.min(sum, minSum);
        }
        return 1 - minSum;
    }
}
