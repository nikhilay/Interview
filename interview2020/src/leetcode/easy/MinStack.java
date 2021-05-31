package leetcode.easy;

import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if (val <= min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);

    }

    public void pop() {
        if (minStack.pop() == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}
