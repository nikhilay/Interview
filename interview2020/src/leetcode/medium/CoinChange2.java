package leetcode.medium;


public class CoinChange2 {
    //https://leetcode.com/problems/coin-change-2/solution/
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
