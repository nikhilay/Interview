package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    //https://leetcode.com/problems/contains-duplicate-ii/discuss/61372/Simple-Java-solution
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) hashSet.remove(nums[i - k - 1]);
            if (!hashSet.add(nums[i])) return true;
        }
        return false;

    }
}
