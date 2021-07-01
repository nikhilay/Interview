package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        subsets(nums, result, 0, new LinkedList<>());
        return result;
    }

    private void subsets(int[] nums, List<List<Integer>> result, int start, List<Integer> list) {
        result.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, result, i + 1, list);
            list.remove(list.size() - 1);

        }
    }
}
