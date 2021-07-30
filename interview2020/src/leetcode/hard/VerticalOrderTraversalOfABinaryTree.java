package leetcode.hard;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return null;
        HashMap<Integer, TreeMap<Integer, LinkedList<Integer>>> memo = new HashMap<>();
        helper(root, memo, 0, 0);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            if (memo.containsKey(i)) {
                LinkedList list = new LinkedList<Integer>();
                for (int level : memo.get(i).keySet()) {
                    Collections.sort(memo.get(i).get(level));
                    list.addAll(memo.get(i).get(level));
                }
                result.add(list);
            }
        }
        return result;
    }

    private void helper(TreeNode root,
                        HashMap<Integer, TreeMap<Integer, LinkedList<Integer>>> memo, int level, int col) {
        if (root == null) return;
        if (!memo.containsKey(col)) memo.put(col, new TreeMap<>());
        min = Math.min(col, min);
        max = Math.max(col, max);
        if (!memo.get(col).containsKey(level)) memo.get(col).put(level, new LinkedList<>());
        memo.get(col).get(level).offer(root.val);
        helper(root.left, memo, level + 1, col - 1);
        helper(root.right, memo, level + 1, col + 1);
    }
}
