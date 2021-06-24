package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) return null;
        int maxSoFar = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxSoFar) {
                result.add(0, i);
            }
            maxSoFar = Math.max(maxSoFar, heights[i]);

        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
