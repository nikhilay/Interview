package leetcode.easy;

public class FindPivotIndex {

    //https://leetcode.com/problems/find-pivot-index/discuss/109274/JavaC%2B%2B-Clean-Code
    public int pivotIndex(int[] nums) {
        if (nums == null) return -1;
        int total = 0;
        int leftSum = 0;
        for (int n : nums) total += n;

        for (int i = 0; i < nums.length; i++) {

            if (leftSum == (total - nums[i] - leftSum)) return i;

            leftSum += nums[i];

        }
        return -1;
    }
}
