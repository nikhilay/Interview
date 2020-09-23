package leetcode.easy;

import java.util.HashSet;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        HashSet<Integer> hashset = new HashSet<>();
        for( int num : nums){
            if(hashset.contains( num)){
                return true;
            }
            hashset.add(num);
        }
        return false;

    }
}
