package leetcode.medium;

import java.util.Arrays;

public class UniquePaths {
    //https://www.youtube.com/watch?v=IlEsdxuD4lY&ab_channel=NeetCode
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[] curr = new int[n];
        Arrays.fill(curr, 1);
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                curr[c] = curr[c] + curr[c -1];
            }

        }
     return curr[n -1];
    }
}
