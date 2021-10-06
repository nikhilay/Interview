package leetcode.medium;

public class GuessNumberHigherOrLowerII {
    //https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(dp, 1, n);
    }

    private int helper(int[][] dp, int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int tmp = i + Math.max(helper(dp, i + 1, end), helper(dp, start, i - 1));
            res = Math.min(tmp, res);
        }
        dp[start][end] = res;
        return dp[start][end];
    }
}
