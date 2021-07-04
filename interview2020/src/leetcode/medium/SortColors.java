package leetcode.medium;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i0 = 0;
        int i2 = nums.length - 1;
        int curr = 0;
        while (curr <= i2) {
            if (nums[curr] == 0) {
                nums[curr] = nums[i0];
                nums[i0] = 0;
                i0++;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[i2];
                nums[i2] = 2;
                i2++;
                //
                curr--;
            }
            curr++;
        }

    }
}
