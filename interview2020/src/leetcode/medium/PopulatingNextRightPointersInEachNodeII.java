package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII {
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/472675/Short-Java-solution-with-explanation-100-runtime-and-100-memory
    //Solution - o(n) time complexity / o(1) space complexity
    public Node connect(Node root) {
         if(root == null) return root;

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNode(root);
            }
        }

        if (root.right != null) {
            root.right.next = findNode(root);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node findNode(Node root){
        while(root.next!=null){
            root = root.next;
            if(root.left!=null) return root.left;
            if(root.right!=null) return root.right;
        }
        return null;
    }


    //My Solution - o(n) time complexity / o(n) space complexity
    public Node connectNikhil(Node root) {
        List<List<Node>> list = new LinkedList<>();
        helper(root, list, 1);
        for (List<Node> level : list) {
            for (int i = 0; i < level.size() - 1; i++) {
                level.get(i).next = level.get(i + 1);
            }
        }
        return root;
    }

    private void helper(Node root, List<List<Node>> list, int depth) {
        if (root == null) return;

        if (list.size() < depth) list.add(new LinkedList<Node>());
        list.get(depth - 1).add(root);
        helper(root.left, list, depth + 1);
        helper(root.right, list, depth + 1);
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;


}
