package leetcode.medium;

public class CountSquareSubmatricesWithAllOnes {
    //https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
    public int countSquares(int[][] matrix) {
        int count = 0;
        if (matrix == null || matrix.length == 0) return count;
        for (int c = 0; c < matrix[0].length; c++) count += matrix[0][c];
        for (int r = 1; r < matrix.length; r++) count += matrix[r][0];
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] = Math.min(matrix[r - 1][c], Math.min(matrix[r][c - 1], matrix[r - 1][c - 1])) + 1;
                    count += matrix[r][c];

                }
            }
        }
        return count;

    }
}
