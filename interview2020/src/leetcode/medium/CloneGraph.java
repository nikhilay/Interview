package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> cloneNodes = new HashMap<>();
        return cloneGraph(node, cloneNodes);
    }

    private Node cloneGraph(Node node, HashMap<Integer, Node> cloneNodes) {
        if(node==null) return null;
        Node clone = new Node(node.val, new ArrayList<Node>());
        cloneNodes.put(node.val, clone);
        for (Node curr : node.neighbors) {
            Node neighClone;
            if (cloneNodes.containsKey(curr.val)) {
                neighClone = cloneNodes.get(curr.val);
            } else {
                neighClone = cloneGraph(curr, cloneNodes);
            }
            clone.neighbors.add(neighClone);
        }
        return clone;
    }
}
