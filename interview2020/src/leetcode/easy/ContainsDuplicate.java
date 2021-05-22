package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
      if (nums==null || nums.length==0) return false;
      Set<Integer> hashSet = new HashSet<>();
      for(int i:nums) {
          if (hashSet.contains(i)) {
              return true;
          }
          hashSet.add(i);
      }
      return false;
    }
}
