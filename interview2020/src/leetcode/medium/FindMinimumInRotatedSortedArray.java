package leetcode.medium;

public class FindMinimumInRotatedSortedArray {
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48484/A-concise-solution-with-proof-in-the-comment
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high]) return nums[low];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
    /*
    Really the BEST solution!! Binary search always bothers me, thanks for sharing. Followings are my understanding from the comments as others reference.

(1) loop is left < right, which means inside the loop, left always < right
(2 ) since we use round up for mid, and left < right from (1), right would never be the same as mid
(3) Therefore, we compare mid with right, since they will never be the same from (2)
(4) if nums[mid] < nums[right], we will know the minimum should be in the left part, so we are moving right.
We can always make right = mid while we don't have to worry the loop will not ends. Since from (2), we know right would never be the same as mid, making right = mid will assure the interval is shrinking.
(5) if nums[mid] > nums[right], minimum should be in the right part, so we are moving left. Since nums[mid] > nums[right],mid can't be the minimum, we can safely move left to mid + 1, which also assure the interval is shrinking
     */
}
