package leetcode.easy;

public class IntersectionOfTwoLinkedLists {
    //https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    /*
    You can prove that: say A length = a + c, B length = b + c, after switching pointer, pointer A
    will move another b + c steps, pointer B will move a + c more steps,
    since a + c + b + c = b + c + a + c, it does not matter what value c is. Pointer A and B
    must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
Thanks, hpplayer. This solution is very smart.
https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!/50080
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
