package leetcode.easy;

public class SquaresOfASortedArray {
    //https://leetcode.com/problems/squares-of-a-sorted-array/discuss/221922/Java-two-pointers-O(N)
    public int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int start = 0;
        int end = size - 1;

        for (int i = size - 1; i >= 0; i--) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                result[i] = nums[start] * nums[start];
                start++;
            } else {
                result[i] = nums[end] * nums[end];
                end--;
            }
        }
    return result;
    }
}
