package leetcode.medium;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int currArea = dfs(grid, row, col);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return 0;
        if (grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1)
                    + dfs(grid, row, col - 1);
        }
        return 0;
    }
}
