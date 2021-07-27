package leetcode.hard;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];

        int maxArea = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int n = matrix[r][c] - '0';
                heights[c] = n == 0 ? 0 : heights[c] + n;
            }
            int currArea = findMaxArea(heights);
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    private int findMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int len = heights.length;
        int maxArea = 0;
        while (i <= len) {
            int h = i == len ? 0 : heights[i];
            if (stack.isEmpty() || h > heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int height = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        return maxArea;
    }
}
