package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        zigzagLevelOrder(root, 1, result);
        return result;
    }

    void zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size()< level) result.add(new LinkedList<>());
        
        if (level % 2 == 0) {
            result.get(level - 1).add(0, root.val);
        } else {
            result.get(level - 1).add(root.val);
        }
        zigzagLevelOrder(root.left, level + 1, result);
        zigzagLevelOrder(root.right, level + 1, result);
    }
}
