package leetcode.medium;

import java.util.Stack;

public class AsteroidCollision {
    //https://leetcode.com/problems/asteroid-collision/solution/733695
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        for (int n : asteroids) {
            boolean push = true;
            while (!stack.isEmpty() && n < 0 && stack.peek() > 0) {
                if (stack.peek() == -n) {
                    stack.pop();
                    push = false;
                    break;
                } else if (stack.peek() < -n) {
                    stack.pop();
                } else {
                    push = false;
                    break;
                }
            }
            if (push) stack.push(n);

        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}
