package leetcode.easy;

public class KthMissingPositiveNumber {
    //https://leetcode.com/problems/kth-missing-positive-number/solution/
    public int findKthPositive(int[] arr, int k) {
        if (arr == null || arr.length == 0) return k;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (arr[pivot] - pivot - 1 < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }

        }
        // arr[right] + k - (arr[right] - right - 1);
        return k + right + 1;
    }
}
