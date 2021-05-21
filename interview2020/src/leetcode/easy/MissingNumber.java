package leetcode.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int missingNumber = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missingNumber = missingNumber ^ i ^ nums[i];
        }
        return missingNumber;
    }
}
