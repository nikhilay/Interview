package leetcode.easy;

public class MergeSortedArrays {

    //https://leetcode.com/problems/merge-sorted-array/discuss/29522/This-is-my-AC-code-may-help-you
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1LastPos = m -1;
        int nums2LastPos = n -1;
        int numsLastPos = m + n -1;

        while(nums1LastPos>=0 && nums2LastPos>=0){
            if(nums1[nums1LastPos]>nums2[nums2LastPos]){
                nums1[numsLastPos--] = nums1[nums1LastPos--];
            } else{
                nums1[numsLastPos--] = nums2[nums2LastPos--];
            }
        }
        while(nums2LastPos>=0){
            nums1[numsLastPos--] = nums2[nums2LastPos--];
        }
    }
}
