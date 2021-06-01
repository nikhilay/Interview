package leetcode.medium;

import leetcode.easy.ListNode;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(-1);
        if (l1 == null && l2 == null) return resultHead.next;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        ListNode prev = resultHead;
        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int digit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(digit);
            prev.next = node;
            prev = prev.next;

        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            prev.next = node;
        }


        return resultHead.next;

    }
}
