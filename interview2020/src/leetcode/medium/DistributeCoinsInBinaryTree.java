package leetcode.medium;

public class DistributeCoinsInBinaryTree {
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        if (root == null) return moves;
        helper(root);
        return moves;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int right = helper(root.right);
        int left = helper(root.left);
        moves += Math.abs(left) + Math.abs(right);
        int total = root.val + left + right - 1;
        return total;
    }
}
