package leetcode.medium;

import leetcode.easy.TreeNode;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,inorder,0,inorder.length-1);

    }


    private TreeNode helper(int[] preOrder, int preOrderRootIndex, int[] inorder, int inOrderStart, int inOrderEnd) {

        if (preOrderRootIndex >= preOrder.length || inOrderStart > inOrderEnd) return null;
        TreeNode root = new TreeNode(preOrder[preOrderRootIndex]);

        int inOrderRootIndex = 0;
        for (int i = inOrderStart; i <=inOrderEnd; i++) {
            if (inorder[i] == root.val) {
                inOrderRootIndex = i;
                break;
            }
        }

        root.left = helper(preOrder, preOrderRootIndex + 1, inorder, inOrderStart, inOrderRootIndex - 1);
        root.right = helper(preOrder, preOrderRootIndex + inOrderRootIndex - inOrderStart + 1, inorder, inOrderRootIndex + 1, inOrderEnd);
        return root;
    }
}
