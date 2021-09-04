package leetcode.medium;

public class WhereWillTheBallFall {
    //https://leetcode.com/problems/where-will-the-ball-fall/discuss/988576/JavaC%2B%2BPython-Solution-with-Explanation
    public int[] findBall(int[][] grid) {
        if (grid == null || grid.length == 0) return null;
        int balls = grid[0].length;
        int[] result = new int[balls];
        for (int i = 0; i < balls; i++) {
            result[i] = getFallingIndex(grid, i);
        }
        return result;
    }

    private int getFallingIndex(int[][] grid, int index) {
        int i1 = index;
        int i2;
        for (int j = 0; j < grid.length; j++) {
            i2 = i1 + grid[j][i1];
            if (i2 < 0 || i2 >= grid[0].length || grid[j][i1] != grid[j][i2]) {
                return -1;
            }
            i1 = i2;
        }
        return i1;
    }
}
