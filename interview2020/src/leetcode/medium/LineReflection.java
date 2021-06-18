package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LineReflection {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) return false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> memo = new HashSet<>();

        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            memo.add(point[0] + "," + point[1]);
        }
        int sum = min + max;

        for (int[] point : points) {
            if (!memo.contains(sum - point[0] + "," + point[1])) return false;
        }
        return true;
    }
}
