package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int n : nums) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) count++;
            } else if (hmap.containsKey(entry.getKey() + k)) {
                count++;
            }
        }

        return count;
    }
//[3,1,4,1,5]
//2// 1 ,1 3, 4 ,5
    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;
        while (left < nums.length && right < nums.length) {

            if (left==right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                count++;
                left++;
                right++;
                while (left < nums.length && nums[left - 1] == nums[left]) left++;
            }
        }
        return count;
    }


}
