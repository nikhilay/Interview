package leetcode.easy;

public class ClosestBinarySearchTreeValue {
    //https://leetcode.com/problems/closest-binary-search-tree-value/discuss/70331/Clean-and-concise-java-solution
    public int closestValue(TreeNode root, double target) {
        return closestValue(root, target, root.val);
    }

    private int closestValue(TreeNode root, double target, int val) {
        if(root==null) return val;

        if (Math.abs(root.val - target) < Math.abs(val - target)) val = root.val;

        if (target < root.val) {
            val = closestValue(root.left, target, val);
        } else {
            val = closestValue(root.right, target, val);
        }
        return val;
    }
}
