package leetcode.easy;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        if (nums == null) return null;
        int[] output = new int[nums.length];
        int i = 0;
        int j = n;
        int k = 0;
        while (j < nums.length) {
            output[k] = nums[i];
            output[k + 1] = nums[j];
            i++;
            j++;
            k+=2;

        }
        return output;
    }
}
