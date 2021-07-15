package leetcode.easy;

public class BalancedBinaryTree {
    //https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better/198436
    public boolean isBalanced(TreeNode root) {
     return helper(root)!=-1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftSubTreeHeight = helper(root.left);
        int rightSubTreeHeight = helper(root.right);

        if (leftSubTreeHeight == -1
                || rightSubTreeHeight == -1
                || Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1)
            return -1;

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }
}
