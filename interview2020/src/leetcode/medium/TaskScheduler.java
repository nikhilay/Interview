package leetcode.medium;

import java.util.Arrays;

public class TaskScheduler {
    //https://leetcode.com/problems/task-scheduler/solution/767378
    //https://leetcode.com/problems/task-scheduler/solution/
    public int leastInterval(char[] tasks, int n) {
        int minTime = 0;
        if (tasks == null || tasks.length == 0) return minTime;

        int[] frequency = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            frequency[tasks[i] - 'A']++;
        }
        Arrays.sort(frequency);
        int maxFreq = frequency[25];
        int idleTime = (maxFreq - 1) * n;

        for (int i = frequency.length - 2; i >= 0; i--) {

            idleTime -= Math.min(maxFreq - 1, frequency[i]);
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
}
