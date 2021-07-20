package leetcode.hard;

public class TrappingRainWater {
    //https://leetcode.com/problems/trapping-rain-water/solution/
    //https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
    public int trap(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int start = 0;
        int end = height.length - 1;

        while (start <= end) {
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax,height[end]);

            if(leftMax < rightMax){
                res += leftMax - height[start];
                start++;
            } else{
                res += rightMax - height[end];
                end--;

            }

        }
        return res;
    }
}
