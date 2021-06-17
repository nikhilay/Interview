package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, result, new LinkedList<>(), 0, 0);
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> result,
                                List<Integer> curr, int sum, int index) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new LinkedList<>(curr));
            return;
        }

        for (int c = index; c < candidates.length; c++) {
            curr.add(candidates[c]);
            combinationSum(candidates, target, result, curr, sum + candidates[c], c);
            curr.remove(curr.size() - 1);
        }
    }
}
