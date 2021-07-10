package leetcode.medium;


public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    //https://www.youtube.com/watch?v=4tZvOEHV6w0&ab_channel=WorkWithGoogler

    private class Pair {
        Node first;
        Node last;

        Pair(Node first, Node last) {
            this.first = first;
            this.last = last;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        return dfs(root).first;
    }

    private Pair dfs(Node root) {

        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return new Pair(root, root);
        }
        Pair leftPair = null;
        if (root.left != null) {
            leftPair = dfs(root.left);
            leftPair.last.right = root;
            root.left = leftPair.last;
        }
        Pair rightPair = null;
        if (root.right != null) {
            rightPair = dfs(root.right);
            rightPair.first.left = root;
            root.right = rightPair.first;
        }
        Node first = leftPair == null ? root : leftPair.first;
        Node last = rightPair == null ? root : rightPair.last;
        first.left = last;
        last.right = first;

        return new Pair(first, last);
    }


}
