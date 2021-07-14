package leetcode.medium;

import java.util.Stack;

public class OnlineStockSpan {
    class Pair {
        int price;
        int span;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }

        void setSpan(int span) {
            this.span = span;
        }
    }

    Stack<Pair> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span = stack.pop().span + span;
        }
        Pair newStock = new Pair(price, span);
        if (stack.isEmpty() || price < stack.peek().price) {
            stack.push(newStock);
        }
        return stack.peek().span;
    }
}
