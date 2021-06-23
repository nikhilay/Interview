package leetcode.medium;

import java.util.Stack;

public class SimplifyPath {
    //https://leetcode.com/problems/simplify-path/solution/
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dir = path.split("/");

        for (String s : dir) {
            if (s.equals(".") || s.isEmpty()) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }
            stack.add(s);
        }

        StringBuilder sb = new StringBuilder();
        for (String folder : stack) {
            sb.append("/");
            sb.append(folder);
        }
        return sb.length() > 0 ? sb.toString() : "/";

    }
}
