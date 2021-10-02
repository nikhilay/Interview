package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/complete-binary-tree-inserter/discuss/178424/C%2B%2BJavaPython-O(1)-Insert
public class CompleteBinaryTreeInserter {
    List<TreeNode> list;

    public CompleteBinaryTreeInserter(TreeNode root) {
        list = new ArrayList<>();
        list.add(root);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).left != null) list.add(list.get(i).left);
            if (list.get(i).right != null) list.add(list.get(i).right);
        }
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        list.add(newNode);
        int n = list.size();
        TreeNode parent;
        if (n % 2 == 1) {
            list.get((n - 2) / 2).right = newNode;
            parent = list.get((n - 2) / 2);
        } else {
            list.get((n - 1) / 2).left = newNode;
            parent = list.get((n - 1) / 2);
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}
