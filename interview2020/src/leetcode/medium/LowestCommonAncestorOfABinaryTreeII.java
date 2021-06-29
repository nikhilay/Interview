package leetcode.medium;

import leetcode.easy.TreeNode;

public class LowestCommonAncestorOfABinaryTreeII {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.
    boolean pFound = false;
    boolean qFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = LCA(root, p, q);
        if(pFound && qFound) return lca;
        return null;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if(root == p){
            pFound = true;
            return root;

        }
        if(root == q){
            qFound = true;
            return root;

        }
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;

    }
}
