package leetcode.medium;

public class CountBinarySubstrings {
    //https://leetcode.com/problems/count-binary-substrings/solution/
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] group = new int[s.length()];
        group[0] = 1;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                group[++index] = 1;
            } else {
                group[index]++;
            }
        }

        int count = 0;

        for (int i = 1; i < group.length; i++) {
            count += Math.min(group[i], group[i - 1]);
        }
        return count;
    }

}
