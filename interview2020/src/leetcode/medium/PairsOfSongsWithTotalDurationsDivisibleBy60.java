package leetcode.medium;

import java.util.HashMap;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    //https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256726/JavaPython-3-O(n)-code-w-comment-similar-to-Two-Sum/644125
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : time) {
            int reducedTime = n % 60;
            int other = reducedTime == 0 ? 0 : 60 - reducedTime;
            count += map.getOrDefault(other, 0);
            map.put(reducedTime, map.getOrDefault(reducedTime, 0) + 1);

        }
        return count;
    }
}
