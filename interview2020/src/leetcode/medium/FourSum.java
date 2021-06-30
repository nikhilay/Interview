package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    //https://leetcode.com/problems/4sum/discuss/8575/Clean-accepted-java-O(n3)-solution-based-on-3sum/265188
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0 || nums.length < 4) return result;
        Arrays.sort(nums);
        if (4 * nums[0] > target) return result;
        if (nums[nums.length - 1] * 4 < target) return result;
        for (int i = 0; i < nums.length; i++) {
            if (i!=0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j!=i+1 && nums[j] == nums[j - 1]) continue;
                int sum = nums[i] + nums[j];
                int low = j + 1;
                int end = nums.length - 1;
                while (low < end) {
                    int val = sum + nums[low] + nums[end];
                    if (val == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[end]));
                        low++;
                        end--;
                        while (low < nums.length && nums[low] == nums[low - 1]) {
                            low++;
                        }
                        while (end >= 0 && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (val < target) {
                        low++;
                    } else {
                        end--;
                    }
                }

            }

        }
        return result;
    }
}
