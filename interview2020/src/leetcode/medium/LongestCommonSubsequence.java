package leetcode.medium;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        int[] prev = new int[text2.length() + 1];
        for (int r = 1; r < text1.length() + 1 ; r++) {
            int[] tmp = new int[text2.length() + 1];
            for (int c = 1; c < text2.length() + 1; c++) {
                if (text1.charAt(r - 1) == text2.charAt(c - 1)) {
                    tmp[c] = prev[c - 1] + 1;
                } else {
                    tmp[c] = Math.max(Math.max(prev[c - 1], prev[c]), tmp[c-1]);
                }
            }
            prev = tmp;
        }
        return prev[text2.length()];
    }
}
