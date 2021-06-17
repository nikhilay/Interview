package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new LinkedList<>();
        if (root == null || target == null) return result;
        findAllNodes(root, target, k, result);
        return result;
    }

    private int findAllNodes(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root == null) {
            return -1;
        } else if (root == target) {
            subtree(root, k, 0, result);
            return 1;
        } else {
            int left = findAllNodes(root.left, target, k, result);
            int right = findAllNodes(root.right, target, k, result);

            if (right > 0) {
                if (k == right) {
                    result.add(root.val);
                    return -1;
                }
                subtree(root.left, k, right + 1, result);
                return right + 1;

            } else if (left > 0) {
                if (k == left) {
                    result.add(root.val);
                    return -1;
                }
                subtree(root.right, k, left + 1, result);
                return left + 1;

            } else {
                return -1;
            }
        }
    }

    private void subtree(TreeNode root, int k, int distance, List<Integer> result) {
        if (root == null) return;
        if (distance == k) {
            result.add(root.val);
            return;
        }
        subtree(root.left, k, distance + 1, result);
        subtree(root.right, k, distance + 1, result);
    }

}
