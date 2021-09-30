package leetcode.medium;

public class MaximumNumberOfPointsWithCost {
    //https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1344870/Java-DP
    public long maxPoints(int[][] points) {
        if (points == null || points.length == 0) ;
        long[] dp = new long[points[0].length];
        long max = 0;
        for (int r = 0; r < points.length; r++) {
            for(int c = 0;c<points[0].length;c++){
                dp[c] += points[r][c];
            }

            for(int c= 1;c<points[0].length;c++){
                dp[c] = Math.max(dp[c],dp[c-1] -1 );
            }

            for(int c= points[0].length -2 ;c>=0;c--){
                dp[c] = Math.max(dp[c],dp[c+1] -1 );
            }

        }

        for (long n : dp) {
            max = Math.max(max, n);
        }
        return max;

    }
}
