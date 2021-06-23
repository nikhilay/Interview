package leetcode.medium;

public class IntegerBreak {
    //https://leetcode.com/problems/integer-break/discuss/80694/Java-DP-solution/85260
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[n];
    }
}
