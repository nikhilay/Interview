package leetcode.medium;

public class LongestLineOfConsecutiveOneInMatrix {
    //https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/discuss/102266/Java-O(nm)-Time-DP-Solution
    public int longestLine(int[][] mat) {
        if(mat==null || mat.length==0) return -1;
        int[][][] dp = new int[mat.length][mat[0].length][4];
        int max = 0;
        for(int r = 0; r < mat.length; r++){
            for(int c = 0; c < mat[r].length; c++){
                if(mat[r][c]==0) continue;
                for(int k = 0;k < 4; k++) dp[r][c][k] = 1;
                if(c>0) dp[r][c][0] +=dp[r][c-1][0];
                if(r>0) dp[r][c][1] +=dp[r-1][c][1];
                if(r>0 && c>0) dp[r][c][2] +=dp[r-1][c-1][2];
                if(r>0 && c<mat[r].length -1 )dp[r][c][3] += dp[r-1][c+1][3];

                max = Math.max(max,dp[r][c][0] );
                max = Math.max(max,dp[r][c][1] );
                max = Math.max(max,dp[r][c][2] );
                max = Math.max(max,dp[r][c][3] );

            }


        }
        return max;
    }
}
