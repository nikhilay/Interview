package leetcode.medium;

public class LowestCommonAncestorOfABinaryTreeIII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    ;
    /*
    You can prove that: say A length = a + c, B length = b + c, after switching pointer, pointer A
    will move another b + c steps, pointer B will move a + c more steps,
    since a + c + b + c = b + c + a + c, it does not matter what value c is. Pointer A and B
    must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
Thanks, hpplayer. This solution is very smart.
https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!/50080
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;

        }
        return a;
    }
}
