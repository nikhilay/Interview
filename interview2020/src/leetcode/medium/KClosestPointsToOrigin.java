package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    //https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]
            }
        });

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][k];
        while (k != 0) {
            result[--k] = pq.poll();
        }
        return result;
    }
}
