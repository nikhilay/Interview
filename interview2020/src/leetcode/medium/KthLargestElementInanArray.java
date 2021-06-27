package leetcode.medium;

import java.util.PriorityQueue;

public class KthLargestElementInanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            if(pq.size() < k){
                pq.offer(n);
            } else if(n>=pq.peek()){
                pq.poll();
                pq.offer(n);
            }
        }
        return pq.peek();
    }
}
