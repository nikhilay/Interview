package leetcode.hard;

import java.util.Stack;

public class BasicCalculator {
    //https://leetcode.com/problems/basic-calculator/discuss/62362/JAVA-Easy-Version-To-Understand!!!!!
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result = result + sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign =1;

            } else if (c == ')') {
                result = stack.pop()* result + stack.pop();
            }
        }


        return result;

    }
}
