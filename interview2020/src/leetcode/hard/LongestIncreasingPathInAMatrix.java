package leetcode.hard;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] memo = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int len = dfs(matrix, memo, dirs, r, c);
                max = Math.max(len, max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] memo, int[][] dirs, int row, int col) {
       if(memo[row][col]!=0) return memo[row][col];
        int max = 1;
        for (int[] dir : dirs) {
            int len = 1;
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= matrix.length
                    || newCol < 0
                    || newCol >= matrix[0].length || matrix[row][col]>=matrix[newRow][newCol]) continue;

             len += dfs(matrix,memo,dirs,newRow, newCol);
             max = Math.max(len, max);

        }
        memo[row][col] = max;
        return max;
    }
}
