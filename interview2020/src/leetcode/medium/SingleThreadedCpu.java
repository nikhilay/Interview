package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCpu {
    // https://leetcode.com/problems/single-threaded-cpu/discuss/1164017/Java-2-PriorityQueues/928645
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        int[] result = new int[len];
        int[][] memo = new int[len][3];
        for (int i = 0; i < len; i++) {
            memo[i][0] = tasks[i][0];
            memo[i][1] = tasks[i][1];
            memo[i][2] = i;
        }
        Arrays.sort(memo, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }

        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
        });
        int index = 0;
        int time = 0;
        int i = 0;
        while (index < len) {
            if (pq.isEmpty()) {
                time = Math.max(time, memo[index][0]);
            }
            while (i < len && memo[i][0] <= time) {
                pq.offer(memo[i]);
                i++;
            }

            int[] curr = pq.poll();
            result[index++] = curr[2];
            time += curr[1];

        }
        return result;

    }
}
