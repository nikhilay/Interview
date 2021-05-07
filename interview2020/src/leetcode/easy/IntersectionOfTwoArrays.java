package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    //https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums1) {
            nums1Set.add(i);
        }

        for (int i : nums2) {
            if (nums1Set.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}
