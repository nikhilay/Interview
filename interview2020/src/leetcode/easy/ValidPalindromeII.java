package leetcode.easy;

public class ValidPalindromeII {
    //https://leetcode.com/problems/valid-palindrome-ii/discuss/107716/Java-O(n)-Time-O(1)-Space
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            System.out.println("l " + l + " r "+ r);
            if (s.charAt(l) != s.charAt(r))
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            l++;
            r--;

        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            System.out.println("l " + l + " r "+ r);
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
