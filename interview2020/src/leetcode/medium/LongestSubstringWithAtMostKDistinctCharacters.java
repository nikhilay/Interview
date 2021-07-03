package leetcode.medium;

public class LongestSubstringWithAtMostKDistinctCharacters {
    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/80047/15-lines-java-solution-using-slide-window
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //Input: s = "eceba", k = 2
        int result = 0;
        int[] count = new int[256];
        int i = 0;
        int num = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while(--count[s.charAt(i++)]>0);
                num--;
            }
            result = Math.max(result, j - i + 1);


        }
        return result;
    }
}
