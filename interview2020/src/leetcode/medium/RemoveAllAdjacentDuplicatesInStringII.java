package leetcode.medium;

public class RemoveAllAdjacentDuplicatesInStringII {
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/discuss/392933/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution
    public String removeDuplicates(String s, int k) {
        if (k == 0) return s;
        int len = s.length();
        int[] count = new int[len];
        char[] uniqueString = new char[len];

        int i = 0;
        for (int j = 0; j < len && i < len; j++, i++) {
            uniqueString[i] = s.charAt(j);

            if (i > 0 && uniqueString[i - 1] == s.charAt(j)) {
                count[i] = count[i - 1] + 1;

            } else {
                count[i] = 1;
            }
            if (count[i] == k) i -= k;
        }

        return new String(uniqueString, 0, i);
    }
}
