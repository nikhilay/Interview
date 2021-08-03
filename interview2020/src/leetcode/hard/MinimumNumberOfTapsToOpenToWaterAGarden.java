package leetcode.hard;

public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public int minTaps(int n, int[] ranges) {

        int[] realRange = new int[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            realRange[left] = Math.max(i + ranges[i] - left, realRange[left]);
        }
        int count = 0;
        int farthestJump = 0;
        int currentJump = 0;
        for (int i = 0; i < realRange.length - 1; i++) {
            farthestJump = Math.max(farthestJump, i + realRange[i]);
            if (i == farthestJump && realRange[i] == 0) return -1;
            if (i == currentJump) {
                count++;
                currentJump = farthestJump;
            }
        }

        return count;
    }
}
