package leetcode.easy;

public class DivisorGame {
    //https://leetcode.com/problems/divisor-game/discuss/274608/Simple-DP-Java-Solution
    public boolean divisorGame(int n) {
        boolean[] memo = new boolean[n + 1];
        memo[0] = false;
        memo[1] = false;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && memo[i - j] == false) {
                    memo[i] = true;
                }
            }
        }

        return memo[n];

    }
}
