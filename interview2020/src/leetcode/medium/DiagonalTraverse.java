package leetcode.medium;

public class DiagonalTraverse {
    //https://leetcode.com/problems/diagonal-traverse/discuss/97712/Concise-Java-Solution
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int m = mat.length;
        int n = mat[0].length;
        int row = 0;
        int col = 0;
        int dir = 0;
        int[] result = new int[m * n];
        int[][] directions = {{-1, 1}, {1, -1}};
        for (int i = 0; i < m * n; i++) {
            System.out.println(mat[row][col]);
            result[i] = mat[row][col];
            row += directions[dir][0];
            col += directions[dir][1];

            if (row >= m) {
                row = m - 1;
                col += 2;
                dir = 1 - dir;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                dir = 1 - dir;
            }

            if (row < 0) {
                row = 0;
                dir = 1 - dir;
            }
            if (col < 0) {
                col = 0;
                dir = 1 - dir;
            }



        }
        return result;
    }
}
