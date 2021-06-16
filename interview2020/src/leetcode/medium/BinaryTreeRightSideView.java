package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        rightSideView(root, result, 1);
        return result;
    }

    private void rightSideView(TreeNode root, List<Integer> result, int height) {
        if (root == null) return;
        if (height > result.size()) result.add(root.val);
        rightSideView(root.right, result, height + 1);
        rightSideView(root.left, result, height + 1);
    }
}
