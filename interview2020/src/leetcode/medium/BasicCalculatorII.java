package leetcode.medium;

import java.util.Stack;

public class BasicCalculatorII {
    // 3/2-3*4+20
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(c) && ' ' != c || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '/') stack.push(stack.pop() / num);
                if (sign == '*') stack.push(stack.pop() * num);
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
