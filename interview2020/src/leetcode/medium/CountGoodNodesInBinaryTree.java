package leetcode.medium;

import leetcode.easy.TreeNode;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return nodes(root, Integer.MIN_VALUE);
    }

    private int nodes(TreeNode root, int maxSoFar) {
        if (root == null) return 0;
        int count = 0;
        if (maxSoFar <= root.val) {
            count++;
        }
        maxSoFar = Math.max(root.val, maxSoFar);
        return count + nodes(root.left, maxSoFar) + nodes(root.right, maxSoFar);
    }
}
