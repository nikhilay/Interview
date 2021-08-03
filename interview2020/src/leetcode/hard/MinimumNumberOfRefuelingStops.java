package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops {
    //https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int currDistance = startFuel;
        int i = 0;
        int count = 0;
        while(currDistance < target){
            while(i < stations.length && currDistance>=stations[i][0]){
                pq.offer(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) return -1;
            count++;
            currDistance += pq.poll();
        }

    return count;
    }
}
