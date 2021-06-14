package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class SprialMatrix {
    //https://leetcode.com/problems/spiral-matrix/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        if (matrix == null || matrix.length == 0) return result;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //Traverse Right
            for (int c = colBegin; c <= colEnd; c++) {
                result.add(matrix[rowBegin][c]);
            }

            //Traverse Down
            rowBegin++;

            for (int r = rowBegin; r <= rowEnd; r++) {
                result.add(matrix[r][colEnd]);
            }

            //Traverse Left
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int c = colEnd; c >= colBegin; c--) {
                    result.add(matrix[rowEnd][c]);
                }
            }

            //Traverse Up
            rowEnd--;
            if (colBegin <= colEnd) {

                for (int r = rowEnd; r >= rowBegin; r--) {
                    result.add(matrix[r][colBegin]);
                }
            }
            colBegin++;

        }
        return result;

    }
}
