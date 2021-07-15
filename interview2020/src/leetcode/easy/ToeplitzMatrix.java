package leetcode.easy;

public class ToeplitzMatrix {
    //https://leetcode.com/problems/toeplitz-matrix/discuss/113417/Java-solution-4-liner.
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) return false;
            }
        }
        return true;
    }
}
