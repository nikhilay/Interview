package leetcode.easy;

public class singleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            result = i ^result;
        }
       return result;
    }
}
