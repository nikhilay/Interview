package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class KnightDialer {
    //https://leetcode.com/problems/knight-dialer/discuss/189287/O(n)-time-O(1)-space-DP-solution-%2B-Google-interview-question-writeup
    //https://www.youtube.com/watch?v=AspiZ9mUghM&ab_channel=RahulManghnani
    //https://www.geeksforgeeks.org/modulo-1097-1000000007/
    //https://medium.com/hackernoon/google-interview-questions-deconstructed-the-knights-dialer-f780d516f029
    public int knightDialer(int n) {
        int modulo = 1000000007;
        int[][] adjList = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        long[][] memo = new long[n + 1][10];
        for (int c = 0; c < 10; c++) {
            memo[1][c] = 1;
        }

        for (int r = 2; r < memo.length; r++) {
            for (int c = 0; c < 10; c++) {
                for (int num : adjList[c]) {
                    memo[r][c] += memo[r - 1][num];
                }
                memo[r][c] = memo[r][c] % modulo;
            }
        }
        long result = 0;
        for (int c = 0; c < 10; c++) {
            result += memo[n][c];
        }
        return (int) (result % modulo);
    }
}
