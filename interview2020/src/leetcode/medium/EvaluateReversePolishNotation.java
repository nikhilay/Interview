package leetcode.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!s.equals("*") && !s.equals("+") && !s.equals("-") && !s.equals("/")) {
                stack.push(Integer.valueOf(s));
                continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            if (s.equals("+")) stack.push(num1 + num2);
            if (s.equals("-")) stack.push(num1 - num2);
            if (s.equals("*")) stack.push(num1 * num2);
            if (s.equals("/")) stack.push(num1 / num2);
        }

        return stack.pop();
    }
}
