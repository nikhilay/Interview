package leetcode.easy;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            orderIndex[c - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (isLeftWordBigger(words[i - 1], words[i], orderIndex)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLeftWordBigger(String s1, String s2, int[] orderIndex) {

        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return orderIndex[s1.charAt(i) - 'a'] > orderIndex[s2.charAt(i) - 'a'];
            }
        }
        return s1.length() > s2.length();
    }
}
