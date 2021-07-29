package leetcode.hard;

public class BinaryTreeMaximumPathSum {
    https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSums(root);
        return maxSum;
    }

    private int maxPathSums(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(0,maxPathSums(root.left));
        int rightSum = Math.max(0,maxPathSums(root.right));
        int sum = root.val + leftSum + rightSum;
        maxSum = Math.max(sum, maxSum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
