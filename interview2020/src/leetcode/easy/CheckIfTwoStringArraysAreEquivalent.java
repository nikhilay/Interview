package leetcode.easy;

public class CheckIfTwoStringArraysAreEquivalent {
    //https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/discuss/967572/Java-4-pointers-and-Iterator-Solution-Doing-it-in-O(1)-space-is-the-trick
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int p1 = 0;
        int w1 = 0;

        int p2 = 0;
        int w2 = 0;

        while (w1 < word1.length && w2 < word2.length) {

            if (word1[w1].charAt(p1) != word2[w2].charAt(p2)) return false;

            if (p1 < word1[w1].length() - 1) {
                p1++;
            } else {
                p1 = 0;
                w1++;
            }
            if (p2 < word2[w2].length() - 1) {
                p2++;
            } else {
                p2 = 0;
                w2++;
            }

        }
        return w1 == word1.length && w2 == word2.length;
    }
}
