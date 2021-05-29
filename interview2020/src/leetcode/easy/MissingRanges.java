package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    //Input: nums = [0,1,3,50,75], lower = 0, upper = 99
    //Output: ["2","4->49","51->74","76->99"]
    //https://leetcode.com/problems/missing-ranges/discuss/50476/Accepted-Java-solution-with-explanation
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(formRange(lower, upper));
            return result;
        }

        if (lower < nums[0]) {
            result.add(formRange(lower, nums[0] - 1));
        }

        for (int i = 0; i < nums.length -1; i++) {

            if (nums[i + 1] > nums[i]+1) {
                result.add(formRange(nums[i] + 1, nums[i+1] - 1));
            }
        }

        if (nums[nums.length - 1] < upper) {
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }

    private String formRange(int lower, int upper) {
        if (lower == upper) return String.valueOf(lower);
        return lower + "->" + upper;
    }
}
