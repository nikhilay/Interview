package leetcode.easy;

public class MajorityElement {
    //https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
    public int majorityElement(int[] nums) {
        int median = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (median == nums[i]) {
                count++;
            } else if (count == 0) {
                count++;
                median = nums[i];
            } else {
                count--;
            }
        }
        return median;
    }
}
