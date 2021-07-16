package leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    //https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
    //496. Next Greater Element I
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> memo = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int n : nums2) {
            while(!stack.isEmpty() && stack.peek() < n){
                memo.put(stack.pop(), n);
            }
            stack.push(n);
        }
        int index = 0;
        for(int n:nums1){
            result[index++] = memo.getOrDefault(n,-1);
        }
    return result;
    }
}
