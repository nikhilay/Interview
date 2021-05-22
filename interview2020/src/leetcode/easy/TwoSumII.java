package leetcode.easy;

public class TwoSumII {
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/51239/Share-my-java-AC-solution.
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2) return null;
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
