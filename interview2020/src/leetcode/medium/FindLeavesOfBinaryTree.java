package leetcode.medium;


import java.util.LinkedList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    private int helper(TreeNode root, List<List<Integer>> result) {
        if (root == null) return 0;
        int leftNum = helper(root.left, result);
        int rightNum = helper(root.right, result);
        int max = Math.max(leftNum, rightNum);
        if(result.size() <= max)result.add(new LinkedList<>());
        result.get(max).add(root.val);
        return max + 1;
    }
}
