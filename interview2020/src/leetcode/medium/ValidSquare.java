package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-square/discuss/103432/4-Liner-Java
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] list = new int[]{squaredistance(p1, p2), squaredistance(p1, p3), squaredistance(p1, p4),
                squaredistance(p2, p3), squaredistance(p2, p4), squaredistance(p3, p4)};
        for (int dist : list) {
            memo.put(dist, memo.getOrDefault(dist, 0) + 1);
        }
        return memo.size() == 2 &&  !memo.containsKey(0) &&  memo.containsValue(4) && memo.containsValue(2);
    }

        private int squaredistance ( int[] p1, int[] p2){
            return ((p2[0] - p1[0]) * (p2[0] - p1[0])) + ((p2[1] - p1[1]) * (p2[1] - p1[1]));
        }

    }
