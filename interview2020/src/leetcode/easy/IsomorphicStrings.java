package leetcode.easy;

public class IsomorphicStrings {
    //https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
