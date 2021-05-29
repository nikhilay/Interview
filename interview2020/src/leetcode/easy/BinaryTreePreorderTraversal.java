package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> result ){
        if(root==null) return;
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }
}
