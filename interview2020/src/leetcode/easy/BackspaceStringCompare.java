package leetcode.easy;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return backspaceString(s).equals(backspaceString(t));

    }

    private String backspaceString(String s) {
        StringBuilder sb = new StringBuilder();
        int countPound = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                countPound++;
                continue;
            }
            if (countPound == 0) {
                sb.append(s.charAt(i));

            } else {
                countPound--;
            }
        }
        return sb.toString();
    }
}
