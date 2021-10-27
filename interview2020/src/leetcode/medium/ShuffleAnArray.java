package leetcode.medium;

import java.util.Random;

public class ShuffleAnArray {
    int[] original;
    int[] nums;
    Random random;

    public ShuffleAnArray(int[] nums) {
        original = new int[nums.length];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
        }
        random = new Random();
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        if (nums == null) return null;
        for (int i = 1; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}

