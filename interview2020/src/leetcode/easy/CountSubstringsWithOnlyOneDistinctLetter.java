package leetcode.easy;

public class CountSubstringsWithOnlyOneDistinctLetter {
    public int countLetters(String S) {
        int result = 0;
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                count++;
            } else {
                result += (count * (count + 1)) / 2;
                count = 1;

            }
        }
        result += (count * (count + 1)) / 2;

        return result;
    }
}
