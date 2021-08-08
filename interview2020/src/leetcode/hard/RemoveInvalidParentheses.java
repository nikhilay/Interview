package leetcode.hard;

import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParentheses {
    //https://www.youtube.com/watch?v=k4LX7OSl2bY&ab_channel=happygirlzt
    //https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/156556
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        dfs(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    private void dfs(String s, List<String> result, int left, int right, char[] brackets) {
        int count = 0;
        int r;
        for (r = right; r < s.length(); r++) {
            char c = s.charAt(r);
            if (c == brackets[0]) {
                count++;
            } else if (c == brackets[1]) {
                count--;
            }
            if (count < 0) break;
        }

        if (count < 0) {
            for (int l = left; l <= r; l++) {
                char c = s.charAt(l);
                if (c == brackets[1] && (l == left || s.charAt(l - 1) != c)) {
                    dfs(s.substring(0, l) + s.substring(l + 1), result, l, r, brackets);
                }
            }

        } else if (count > 0) {
            String reverseString = new StringBuilder(s).reverse().toString();
            dfs(reverseString, result, 0, 0, new char[]{')', '('});
        } else {
            result.add(brackets[0] == '(' ? s : new StringBuilder(s).reverse().toString());
        }
    }
}
