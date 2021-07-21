package leetcode.hard;

public class FirstMissingPositive {
    //https://leetcode.com/problems/first-missing-positive/solution/
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > len) nums[i] = len + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num > len) continue;
           num--;
            if(nums[num]>0){
                nums[num] = -nums[num];
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) return i + 1 ;
        }
        return len + 1;
    }
}
