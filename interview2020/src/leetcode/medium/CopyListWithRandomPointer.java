package leetcode.medium;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node oldList = head;

            //Weave the two lists
            while (oldList != null) {
                Node node = new Node(oldList.val);
                node.next = oldList.next;
                oldList.next = node;
                oldList = oldList.next.next;
            }

            //Add Random Pointer

            oldList = head;
            while (oldList != null) {
                oldList.next.random = oldList.random == null ? null : oldList.random.next;
                oldList = oldList.next.next;
            }

            //Unweave them
            oldList = head;
            Node newHead = head.next;
            Node prev;
            while (oldList != null) {
                prev = oldList.next;
                oldList.next = oldList.next.next;
                prev.next = prev.next == null ? null : prev.next.next;
                oldList = oldList.next;
            }
            return newHead;
        }

    }
}
