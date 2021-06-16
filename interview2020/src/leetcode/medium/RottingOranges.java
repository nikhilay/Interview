package leetcode.medium;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int minute = 2;
        while (haveOrangesRotted(grid, minute)) {
            minute++;
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return minute - 2;
    }

    private boolean haveOrangesRotted(int[][] grid, int minute) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean anyOrangeRottedSoFar = false;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == minute) {
                    for (int[] dir : directions) {
                        int nrow = row + dir[0];
                        int ncol = col + dir[1];
                        if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[row].length) {
                            if (grid[nrow][ncol] == 1) {
                                grid[nrow][ncol] = minute + 1;
                                anyOrangeRottedSoFar = true;
                            }
                        }
                    }

                }

            }
        }
        return anyOrangeRottedSoFar;
    }
}
