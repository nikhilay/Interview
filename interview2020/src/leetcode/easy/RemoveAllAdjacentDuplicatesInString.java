package leetcode.easy;

public class RemoveAllAdjacentDuplicatesInString {
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294893/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
