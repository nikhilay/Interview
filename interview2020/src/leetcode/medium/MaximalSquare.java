package leetcode.medium;

public class MaximalSquare {
    //https://leetcode.com/problems/maximal-square/discuss/61803/C%2B%2B-space-optimized-DP
    //https://leetcode.com/problems/maximal-square/discuss/61802/Extremely-Simple-Java-Solution-%3A)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];
        int maxLen = 0;
        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[i].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    memo[i][j] = Math.min(Math.min(memo[i - 1][j], memo[i][j - 1]), memo[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, memo[i][j]);
                }

            }
        }
        return maxLen * maxLen;
    }
}
