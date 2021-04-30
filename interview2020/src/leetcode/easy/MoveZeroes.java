package leetcode.easy;

public class MoveZeroes {

//https://leetcode.com/problems/move-zeroes/discuss/72011/Simple-O(N)-Java-Solution-Using-Insert-Index
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int pivot = 0;
        for(int num: nums){
            if(num!=0){
                nums[pivot++] = num;
            }
        }

        while ( pivot< nums.length){
            nums[pivot++] = 0;
        }


    }
}
