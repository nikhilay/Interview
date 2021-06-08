package leetcode.medium;

import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum  = 13000;
        for (int i = 0; i< nums.length; i++) {
            int first = nums[i];
            int low = i+1;
            int high = nums.length-1;
            while(low < high) {
                int sum = first + nums[low] + nums[high];
                if(Math.abs(target- sum) < Math.abs(target- closestSum)){
                    closestSum = sum;
                }

                if (sum > target) {
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }
}
