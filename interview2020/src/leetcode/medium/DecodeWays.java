package leetcode.medium;

public class DecodeWays {
    //https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
    public int numDecodings(String s) {
        if (s.isEmpty()) return 0;
        int l = s.length();
        int[] memo = new int[l + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= l; i++) {
            int single = Integer.valueOf(s.substring(i - 1, i));
            int combined = Integer.valueOf(s.substring(i - 2, i));

            if (single >= 1 && single <= 9) {
                memo[i] += memo[i - 1];
            }
            if (combined >= 10 && combined <= 26) {
                memo[i] += memo[i - 2];
            }
        }
        return memo[l];
    }
}
