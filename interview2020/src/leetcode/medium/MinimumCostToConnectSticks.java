package leetcode.medium;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length < 2) return 0;
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : sticks) pq.offer(n);

        while (pq.size() > 1) {
            int workDone = pq.poll() + pq.poll();
            cost += workDone;
            pq.offer(workDone);
        }
        return cost;
    }
}
