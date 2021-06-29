package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.offer(root);
        cols.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = cols.poll();
            if (!map.containsKey(level)) {
                map.put(level, new LinkedList<>());
            }
            map.get(level).add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                cols.offer(level - 1);

            }
            if (node.right != null) {
                queue.offer(node.right);
                cols.offer(level + 1);

            }
            min = Math.min(min, level);
            max = Math.max(max, level);
        }
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
            }
        }
        return result;
    }
}
