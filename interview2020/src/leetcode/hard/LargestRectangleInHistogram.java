package leetcode.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution/213800
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack() {};

        int i = 0;
        int len = heights.length;
        int maxArea = 0;
        while (i <= len) {
            int h = i == len ? 0 : heights[i];

            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int height = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                maxArea = Math.max(maxArea, height * (rightBoundary - leftBoundary + 1));

            }

        }
        return maxArea;
    }
}
