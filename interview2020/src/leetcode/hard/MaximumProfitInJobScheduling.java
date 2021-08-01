package leetcode.hard;

import java.util.*;

public class MaximumProfitInJobScheduling {
    //https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408957/DP%2BBinary-search-(Java)
    // Sort by end time
    // Use Array only for faster time
    private class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        Job[] jobsList = new Job[len];
        for (int i = 0; i < len; i++) {
            jobsList[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobsList, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.end - o2.end;
            }
        });

        int[] memo = new int[len];
        memo[0] = jobsList[0].profit;
        for (int i = 1; i < jobsList.length; i++) {
            int gain = jobsList[i].profit;
            int found = search(jobsList, i);
            if (found != -1) {
                gain += memo[found];
            }
            memo[i] = Math.max(gain, memo[i - 1]);

        }
        return memo[len - 1];
    }

    private int search(Job[] jobsList, int index) {
        int start = 0;
        int end = index - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(jobsList[mid].end <= jobsList[index].start){
                if(mid +1 < index && jobsList[mid + 1].end <=jobsList[index].start){
                    start = mid +1;
                } else {
                    return mid;
                }

            } else{
                end = mid -1 ;
            }
        }
        return -1;
    }
}
