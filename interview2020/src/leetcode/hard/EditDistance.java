package leetcode.hard;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int c = 1; c < dp[0].length; c++) {
            dp[0][c] = c;
        }
        for (int r = 1; r < dp.length; r++) {
            dp[r][0] = r;
        }

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                if (word2.charAt(c - 1) == word1.charAt(r - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c - 1], dp[r - 1][c]), dp[r][c - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];


    }
}
