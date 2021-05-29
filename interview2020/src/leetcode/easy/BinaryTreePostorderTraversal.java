package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
