package leetcode.medium;

public class PaliindromicStrings {
    //https://leetcode.com/problems/palindromic-substrings/solution/
    //Approach 3
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += countPalindromeAroundCenters(s, i, i);
            result += countPalindromeAroundCenters(s, i, i + 1);
        }

        return result;
    }

    private int countPalindromeAroundCenters(String s, int low, int high) {
        int res = 0;
        while (low >= 0 && high < s.length()) {

            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            low--;
            high++;
            res++;
        }
        return res;
    }
}
