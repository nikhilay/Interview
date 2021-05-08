package leetcode.easy;

public class RepeatedSubstringPattern {
//https://leetcode.com/problems/repeated-substring-pattern/discuss/94352/Java-Simple-Solution-with-Explanation
    public boolean repeatedSubstringPattern(String s) {

        int l = s.length();
        for (int i = l / 2; i > 0; i--) {
            String subStr = s.substring(0, i);
            int noOfConcat = l / i;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < noOfConcat; j++) {
                sb.append(subStr);
            }
            if (sb.toString().equals(s)) return true;
        }
        return false;
    }
}
