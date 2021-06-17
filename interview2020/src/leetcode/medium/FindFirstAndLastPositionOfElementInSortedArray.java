package leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = findIndex(nums, target, true);
        if (firstOccurence == -1) return new int[]{-1, -1};
        int lastOccurence = findIndex(nums, target, false);
        return new int[]{firstOccurence, lastOccurence};
    }

    private int findIndex(int[] nums, int target, boolean isFirstOccurence) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {

                if (isFirstOccurence) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    if (mid == high || nums[mid + 1] != target) {
                        return mid;
                    }
                    low = mid + 1;

                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }
}
