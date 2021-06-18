package leetcode.medium;

public class LongestPalindromicSubstring {
    //https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution
    // https://www.youtube.com/watch?v=XYQecbcd6_c&ab_channel=NeetCode
    int start = 0;
    int maxLen = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
            maxLen = k - j - 1;
            start = j + 1;
        }
    }
}
