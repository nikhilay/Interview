package leetcode.medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long left = mid - 1 >= 0 ? nums[mid - 1] : Long.MIN_VALUE;
            long right = mid + 1 < nums.length ? nums[mid + 1] : Long.MIN_VALUE;

            if (nums[mid] > right && nums[mid] > left) {
                return mid;
            } else if (right > nums[mid]) {
                low = mid + 1;
            } else if (left > nums[mid]) {
                high = mid - 1;

            }
        }
        return low;
    }
}
