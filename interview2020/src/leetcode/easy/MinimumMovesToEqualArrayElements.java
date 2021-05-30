package leetcode.easy;

public class MinimumMovesToEqualArrayElements {
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
    public int minMoves(int[] nums) {
        int minMoves = 0;
        if (nums == null || nums.length == 0) return minMoves;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : nums) {
            min = Math.min(n, min);
            sum += n;
        }
        return sum - nums.length * min;
    }
}
