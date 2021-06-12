package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    //https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        backtracking("", 0, 0, n, list);
        return list;
    }

    private void backtracking(String s, int open, int close, int len, List<String> list) {


        if (s.length() == len * 2) {
            list.add(s);
            return;
        }

        if (open < len) backtracking(s + "(", open + 1, close, len, list);
        if (close < open) backtracking(s + ")", open, close + 1, len, list);
    }
}
