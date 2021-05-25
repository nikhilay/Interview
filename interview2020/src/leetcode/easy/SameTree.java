package leetcode.easy;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean isLeftTreeSame = isSameTree(p.left, q.left);
        boolean isRightTreeSame = isSameTree(p.right, q.right);
        return isLeftTreeSame && isRightTreeSame;
    }
}
