package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    //https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
    //https://www.youtube.com/watch?v=DfljaUwZsOk&ab_channel=NeetCode
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dequeue = new ArrayDeque<>();
        int resIndex = 0;
        //0 1   2  3 4
        // 9 11 -3 4  6 k= 2
        for (int i = 0; i < nums.length; i++) {

            while (!dequeue.isEmpty() && dequeue.peek() < i + 1 - k) {
                dequeue.poll();
            }

            // 5 4  3 2 1
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] <= nums[i]) {
                dequeue.pollLast();
            }
            dequeue.offer(i);
            if (i + 1 >= k) {
                result[resIndex++] = nums[dequeue.peek()];
            }
        }
        return result;
    }
}
