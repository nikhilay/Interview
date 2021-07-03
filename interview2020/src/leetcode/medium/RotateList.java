package leetcode.medium;

import leetcode.easy.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        for (int i = 0; i < k % size; i++) {
            head = rotate(head);
        }

        return head;
    }

    private ListNode rotate(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }
        curr.next = head;
        prev.next = null;
        return curr;
    }
}
