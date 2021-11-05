package leetcode.medium;

import java.util.Arrays;

public class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxRowGap = Math.max(h - horizontalCuts[horizontalCuts.length - 1], horizontalCuts[0] - 0);
        long maxColGap = Math.max(w - verticalCuts[verticalCuts.length - 1], verticalCuts[0] - 0);
        int mod = 1000000007;
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxRowGap = Math.max(maxRowGap, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        for (int i = 1; i < verticalCuts.length; i++) {
            maxColGap = Math.max(maxColGap, verticalCuts[i] - verticalCuts[i - 1]);

        }

        int result = (int) ((maxRowGap * maxColGap) % mod);
        return result;
    }
}
