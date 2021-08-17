package leetcode.hard;

//https://leetcode.com/problems/find-the-closest-palindrome/discuss/147949/Thinking-Process
public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        long num = Long.valueOf(n);
        int len = n.length();
        // number less than 10 and num= 100, 10000, 10000....
        if (num <= 10 || (num % 10 == 0 && n.charAt(0) == '1' && Long.valueOf(n.substring(1)) == 0))
            return num - 1 + "";

        //number = 101, 1001, 10001
        if (num==11 || (num % 10 == 1 && n.charAt(0) == '1'
                && n.charAt(len - 1) == '1'
                && Long.valueOf(n.substring(1, len - 1)) == 0))
            return num - 2 + "";

        //numbers like 99, 999
        if (allDigitsNine(n)) return num + 2 + "";

        boolean isEvenLength = len % 2 == 0;

        String sPalindromeRoot = isEvenLength ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);
        long nPalindromeRoot = Long.valueOf(sPalindromeRoot);

        String equal = createPalindrome("" + nPalindromeRoot, isEvenLength);
        long diffEqual = Math.abs(Long.valueOf(equal) - num);

        String higher = createPalindrome("" + (nPalindromeRoot + 1), isEvenLength);
        long diffHigher = Math.abs(Long.valueOf(higher) - num);

        String lower = createPalindrome("" + (nPalindromeRoot - 1), isEvenLength);
        long diffLower = Math.abs(Long.valueOf(lower) - num);

        String res = diffHigher < diffLower ? higher : lower;
        long diffRes = Math.min(diffHigher, diffLower);

        if (diffEqual != 0) {
            if (diffEqual < diffRes) return equal;
            if (diffEqual == diffRes) {
                return "" + Math.min(Long.valueOf(res), Long.valueOf(equal));
            }

        }

        return res;
    }

    private String createPalindrome(String sPalindromeRoot, boolean isEvenLength) {
        String reverse = new StringBuilder(sPalindromeRoot).reverse().toString();
        return isEvenLength ? sPalindromeRoot + reverse : sPalindromeRoot + reverse.substring(1);
    }

    private boolean allDigitsNine(String n) {
        for (char c : n.toCharArray()) {
            if (c != '9') return false;
        }
        return true;
    }
}
