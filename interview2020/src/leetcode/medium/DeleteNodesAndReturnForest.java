package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DeleteNodesAndReturnForest {
    //https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/?currentPage=1&orderBy=most_votes&query=
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        List<TreeNode> result = new LinkedList<>();
        for (int i : to_delete) {
            set.add(i);
        }
        helper(root, set, result, true);
        return result;
    }

    private TreeNode helper(TreeNode node, HashSet<Integer> set, List<TreeNode> result, boolean isRoot) {
        if (node == null) return null;
        boolean to_be_deleted = set.contains(node.val);
        if (isRoot && !to_be_deleted) result.add(node);
        node.left = helper(node.left, set, result, to_be_deleted);
        node.right = helper(node.right, set, result, to_be_deleted);
        return to_be_deleted ? null : node;
    }
}
