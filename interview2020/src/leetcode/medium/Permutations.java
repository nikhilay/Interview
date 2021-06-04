package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    //https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(nums, new LinkedList<>(), result);
        return result;
    }

    private void backTrack(int[] nums, List<Integer> permutation, List<List<Integer>> result) {

        if (permutation.size() == nums.length) {
            result.add(new LinkedList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(permutation.contains(nums[i]))continue;
            permutation.add(nums[i]);
            backTrack(nums,permutation, result);
            permutation.remove(permutation.size()-1);
        }
    }
}
