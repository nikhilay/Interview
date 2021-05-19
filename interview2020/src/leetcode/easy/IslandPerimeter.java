package leetcode.easy;

public class IslandPerimeter {
    //https://leetcode.com/problems/island-perimeter/discuss/95001/clear-and-easy-java-solution
    public int islandPerimeter(int[][] grid) {
        if (grid == null) return -1;
        int land = 0;
        int neighbors = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    land++;
                    if (col < grid[row].length - 1 && grid[row][col + 1] == 1) neighbors++;
                    if (row < grid.length - 1 && grid[row + 1][col] == 1) neighbors++;
                }
            }
        }
        return 4 * land - 2 * neighbors;
    }
}
