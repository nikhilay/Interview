package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    //https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        //Get all the intervals whose end time is before the start time of new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            int start = Math.min(intervals[i][0], newInterval[0]);
            int end = Math.max(intervals[i][1], newInterval[1]);
            newInterval = new int[]{start, end};
            i++;
        }
        result.add(newInterval);

        //Get all the intervals whose start time is after the merged interval end time
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][2]);
    }
}
