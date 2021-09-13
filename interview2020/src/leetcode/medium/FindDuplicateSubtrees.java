package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    //https://leetcode.com/problems/find-duplicate-subtrees/discuss/128612/Post-order-Traversal-%2B-Post-orderPre-order-Serialization
    // Why inorder won't work?
    //https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution/247483
    // Why HashSet won't work?
    // becuase if we have three duplicates, it will add for the second and third check
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        encode(root, result, map);
        return result;
    }

    private String encode(TreeNode root, List<TreeNode> result, Map<String, Integer> map) {
        if (root == null) return "#";
        String serial = root.val + ", " + encode(root.left, result, map) + ", " + encode(root.right, result, map);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) result.add(root);
        return serial;
    }
}
