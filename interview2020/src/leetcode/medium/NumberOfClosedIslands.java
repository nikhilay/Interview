package leetcode.medium;

public class NumberOfClosedIslands {
    //https://leetcode.com/problems/number-of-closed-islands/discuss/425150/JavaC++-with-picture-Number-of-Enclaves/384204
    public int closedIsland(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    result++;
                }

            }
        }
        return result;

    }

    private boolean dfs(int[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length) return false;
        if (grid[r][c] == 1) return true;
        grid[r][c] = 1;
        boolean top = dfs(grid, r -1, c);
        boolean right = dfs(grid, r, c+1);
        boolean down = dfs(grid, r +1, c);
        boolean left = dfs(grid, r, c -1);
        return top && right && left && down;
    }

}
