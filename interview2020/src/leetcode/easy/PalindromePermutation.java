package leetcode.easy;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount[c - 'a']++;
        }
        int count = 0;
        for (int i : charCount) {
            count += i % 2;
        }
        return count <= 1;
    }
}
