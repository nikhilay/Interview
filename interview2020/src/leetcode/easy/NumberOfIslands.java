package leetcode.easy;

public class NumberOfIslands {
    //https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        if (grid == null || grid.length == 0) return numberOfIslands;
        int colLength = grid[0].length;
        int rowLength = grid.length;

        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') return;

        grid[r][c] = '0';
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }
}
