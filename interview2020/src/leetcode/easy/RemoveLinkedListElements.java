package leetcode.easy;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
