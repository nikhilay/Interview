package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    //https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510262/Detailed-analysisLet-me-lead-you-to-the-solution-step-by-step
    //https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510263/JavaC%2B%2BPython-Priority-Queue
    public int maxEvents(int[][] events) {
        int ans = 0;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int n = events.length;
        for (int d = 1; d <= 100000; d++) {
            while (i < n && events[i][0] <= d) {
                pq.offer(events[i++][1]);
            }
            if(!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
            while(!pq.isEmpty() && pq.peek() == d) pq.poll();

        }
        return ans;

    }
}
