package leetcode.medium;

import leetcode.easy.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }

        }
        if (isCycle) {
            slow = head;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }

        return null;
    }
}
