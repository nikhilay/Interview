package leetcode.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    Queue<Integer> pq;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        pq = new PriorityQueue<Integer>(k);
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);

        }
        return pq.peek();
    }

}
