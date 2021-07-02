package leetcode.medium;


public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[] memo = new int[grid[0].length];
        memo[0] = grid[0][0];
        for (int c = 1; c < grid[0].length; c++) {
            memo[c] = memo[c - 1] + grid[0][c];
        }
        for (int r = 1; r < grid.length; r++) {
            memo[0] += grid[r][0];
            for (int c = 1; c < grid[r].length; c++) {
                memo[c] = Math.min(memo[c - 1], memo[c]) + grid[r][c];

            }
        }
        return memo[grid[0].length - 1];
    }
}
