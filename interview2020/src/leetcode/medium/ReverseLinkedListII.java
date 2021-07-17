package leetcode.medium;

import leetcode.easy.ListNode;

//https://www.youtube.com/watch?v=wk8-_M-2fzI&ab_channel=leetuition
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;
        dummy.next = head;
        for (int i = 0; i < left - 1 ; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode NEXT = curr.next;

        for (int i = 0; i < right - left; i++) {
            curr.next = NEXT.next;
            NEXT.next = prev.next;
            prev.next = NEXT;
            NEXT = curr.next;

        }
        return dummy.next;
    }
}
