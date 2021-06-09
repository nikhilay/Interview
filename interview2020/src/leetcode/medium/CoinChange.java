package leetcode.medium;

public class CoinChange {
    //https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int overallMinNoOfCoins = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int min = dp[sum - coin] + 1;
                    if (overallMinNoOfCoins < 0)  overallMinNoOfCoins = min;
                    if(min < overallMinNoOfCoins){
                        overallMinNoOfCoins = min;
                    }
                }
            }
            dp[sum] = overallMinNoOfCoins;
        }

        return dp[amount];
    }
}
