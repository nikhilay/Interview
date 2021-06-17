package leetcode.medium;

import leetcode.easy.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/discuss/32109/My-simple-Java-solution-in-3-lines
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBst(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <=minVal) return false;
        return isValidBst(root.left, minVal,root.val ) && isValidBst(root.right, root.val, maxVal);
    }
}
