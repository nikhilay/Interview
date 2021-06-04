package leetcode.medium;

import java.util.Stack;

public class DailyTemperatures {
    //https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = null;
        if (temperatures == null || temperatures.length == 0) return result;
        result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int lowTempIndex = stack.pop();
                result[lowTempIndex] = i - lowTempIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
