package leetcode.easy;

public class MonotonicArray {
    //https://leetcode.com/problems/monotonic-array/discuss/165889/C%2B%2BJavaPython-One-Pass-O(N)
    public boolean isMonotonic(int[] nums) {
        boolean incr = true;
        boolean decr = true;

        for (int i = 1; i < nums.length; i++) {
            incr = incr & nums[i - 1] <= nums[i];
            decr = decr & nums[i - 1] >= nums[i];
        }

        return incr || decr;
    }
}
