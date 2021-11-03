package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;

public class MakingALargeIsland {
    //https://leetcode.com/problems/making-a-large-island/discuss/127015/C%2B%2B-with-picture-O(n*m)
    // https://leetcode.com/problems/making-a-large-island/discuss/127015/C++-with-picture-O(n*m)/134932


    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // Because 0 and 1 are in the orignal grid
        int colorIndex = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, colorIndex);
                    map.put(colorIndex, area);
                    colorIndex++;
                }
            }
        }

        int maxArea = map.getOrDefault(2, 0);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 0) {
                    HashSet<Integer> set = new HashSet<>();

                    //is UP of any color
                    if (r > 0 && grid[r - 1][c] != 0) set.add(grid[r - 1][c]);
                    //is down of any color
                    if (r < grid.length - 1 && grid[r + 1][c] != 0) set.add(grid[r + 1][c]);
                    //is left of any color
                    if (c > 0 && grid[r][c - 1] != 0) set.add(grid[r][c - 1]);
                    //is right of any color
                    if (c < grid.length - 1 && grid[r][c + 1] != 0) set.add(grid[r][c + 1]);

                    // we are flipping this 0 to 1 and adding that area
                    int area = 1;
                    for (int color : set) {
                        area += map.get(color);
                    }
                    maxArea = Math.max(maxArea, area);

                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col, int colorIndex) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid.length || grid[row][col] != 1) return 0;
        grid[row][col] = colorIndex;
        return 1 + dfs(grid, row + 1, col, colorIndex) + dfs(grid, row - 1, col, colorIndex)
                + dfs(grid, row, col + 1, colorIndex) + dfs(grid, row, col - 1, colorIndex);

    }

}
