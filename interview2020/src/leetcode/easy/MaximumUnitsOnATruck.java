package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int units = 0;
        if (boxTypes == null || boxTypes.length == 0) return units;
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int[] box : boxTypes) {
            int noOfBoxes = Math.min(truckSize, box[0]);
            units += noOfBoxes * box[1];
            truckSize -= noOfBoxes;
            if (truckSize == 0) break;

        }
        return units;
    }
}
