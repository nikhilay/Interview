package leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
   // https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/11769/5-lines-Java-solution
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j =0; j<nums.length ;j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }
}
