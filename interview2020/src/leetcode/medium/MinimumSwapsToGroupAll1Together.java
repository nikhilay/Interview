package leetcode.medium;

//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/discuss/355506/JavaSliding-window-O(n)-with-detailed-explanation-very-easy-to-understand
public class MinimumSwapsToGroupAll1Together {
    public int minSwaps(int[] data) {
        if (data == null || data.length == 0) return 0;
        int totalOnes = 0;
        for (int n : data) {
            if (n == 1) totalOnes++;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;
        while (end < data.length) {
            while (end < data.length && end - start < totalOnes) {
                if (data[end] == 1) count++;
                end++;
            }
            max = Math.max(max, count);
            if (end == data.length) break;

            if (data[start] == 1) {
                count--;
            }
            start++;

        }
        return totalOnes - max;
    }
}
