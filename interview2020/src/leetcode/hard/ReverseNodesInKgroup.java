package leetcode.hard;

public class ReverseNodesInKgroup {
    //https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11440/Non-recursive-Java-solution-and-idea
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;
        while(head!=null){
            i++;
            if(i % k ==0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }

        }
    return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = begin;
        ListNode first = curr;

        while (curr != end) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}
