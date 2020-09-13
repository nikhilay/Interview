package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return null;
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            if( map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);

        }
        return result;
    }

   //Accepted Solution: https://leetcode.com/problems/two-sum/discuss/3/Accepted-Java-O(n)-Solution
}
