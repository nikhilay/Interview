package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {

            if (i == 0 || nums[i - 1] != nums[i]) {

                findTriplet(nums, result, i);

            }
        }
        return result;
    }

    private void findTriplet(int[] nums, List<List<Integer>> result, int index) {
        int low = index + 1;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[index] + nums[low] + nums[high];

            if (sum < 0) {
                low++;

            } else if (sum > 0) {
                high--;
            } else {
                result.add(Arrays.asList(nums[index], nums[low], nums[high]));
                low++;
                high--;
                System.out.println(low + " " + high);
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }

            }
        }

    }
}
