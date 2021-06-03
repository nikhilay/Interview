package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        levelOrder(root, result, 0);
        return result;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrder(root.left, result, level + 1);
        levelOrder(root.right, result, level + 1);
    }
}
