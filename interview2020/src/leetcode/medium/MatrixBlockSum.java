package leetcode.medium;

public class MatrixBlockSum {
    //https://leetcode.com/problems/matrix-block-sum/discuss/477036/JavaPython-3-PrefixRange-sum-w-analysis-similar-to-LC-30478
    //https://www.youtube.com/watch?v=-d8KbQVx-mM&ab_channel=GeeksforGeeks
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                memo[i + 1][j + 1] = memo[i + 1][j] + memo[i][j + 1] - memo[i][j] + mat[i][j];
            }
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int r1 = Math.max(0, i-k);
                int c1 = Math.max(0, j-k);
                int r2 = Math.min(m, i+k+1);
                int c2 = Math.min(n, j+k+1);
                result[i][j] =  memo[r2][c2] - memo[r2][c1] -memo[r1][c2] +memo[r1][c1];
            }
        }
        return result;
    }
}
