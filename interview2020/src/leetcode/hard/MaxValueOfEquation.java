package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxValueOfEquation {
    //https://leetcode.com/problems/max-value-of-equation/discuss/709264/Java-Max-Heap-O(nlogn)-and-Monotone-Queue-O(n)
    public int findMaxValueOfEquation(int[][] points, int k) {
        if (points == null || points.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - b[0] - (a[1] - a[0]);
            }
        });

        for (int[] point : points) {
            while(!pq.isEmpty() && point[0] - pq.peek()[0] >k){
                pq.poll();
            }

            if(!pq.isEmpty()){
                max = Math.max(max, point[1] + pq.peek()[1] + point[0] - pq.peek()[0]);
            }

            pq.offer(point);

        }
        return max;
    }
}
