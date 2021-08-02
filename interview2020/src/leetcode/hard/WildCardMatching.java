package leetcode.hard;

public class WildCardMatching {
    //https://www.youtube.com/watch?v=3ZDZ-N0EPV0&t=308s&ab_channel=TusharRoy-CodingMadeSimple
    //https://leetcode.com/problems/wildcard-matching/discuss/17812/My-java-DP-solution-using-2D-table/17699
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // empty string and empty pattern is always = true
        dp[0][0] = true;

        //empty pattern and string  will be always false

        for (int r = 1; r < dp.length; r++) {
            dp[r][0] = false;
        }

        // first character in pattern if * = true otherwise false
        for (int c = 1; c < dp[0].length; c++) {

            if (p.charAt(c - 1) == '*') {
                dp[0][c] =  dp[0][c-1];
            }
        }

        for (int r = 1; r <= s.length(); r++) {
            for (int c = 1; c <= p.length(); c++) {
                if (s.charAt(r - 1) == p.charAt(c - 1) || p.charAt(c - 1) == '?') {
                    dp[r][c] = dp[r - 1][c - 1];
                } else if(p.charAt(c - 1) == '*'){
                    dp[r][c] = dp[r][c-1] || dp [r -1][c];
                }

            }
        }

    return dp[s.length()][p.length()];
    }
}
