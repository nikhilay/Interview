package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    //https://www.youtube.com/watch?v=ARkl69eBzhY&ab_channel=NickWhite
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);
        for (int i = 0; i < len * 2; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                result[stack.pop()] = nums[i % len];
            }
            if (i < len) stack.push(i);
        }
        return result;
    }
}
