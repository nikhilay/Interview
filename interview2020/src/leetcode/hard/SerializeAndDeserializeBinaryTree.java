package leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();

    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String s = queue.poll();

        if (s.equals("X")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}
