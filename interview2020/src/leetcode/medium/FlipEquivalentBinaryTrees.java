package leetcode.medium;

public class FlipEquivalentBinaryTrees {
    //https://leetcode.com/problems/flip-equivalent-binary-trees/discuss/200514/JavaPython-3-DFS-3-liners-and-BFS-with-explanation-time-and-space%3A-O(n).
    //time complexity
    //https://leetcode.com/problems/flip-equivalent-binary-trees/discuss/200514/JavaPython-3-DFS-3-liners-and-BFS-with-explanation-time-and-space:-O(n)./413128
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return root1==root2;
        return root1.val==root2.val && (
                (flipEquiv(root1.left, root2.left)&& flipEquiv(root1.right,root2.right)) ||
                        (flipEquiv(root1.left, root2.right)&& flipEquiv(root1.right,root2.left)));
    }

    //Time complexity
    // each height calls 4^1(root node), 4^2( 4 calls from root and those 4 calls will do 4 more call= 4+4+4+4
    // 4 ^ h  where h=log n
    // or 2 ^ log n^2 and if we assume log to the base 2
    //n ^ 2
    // but, half of the recursive calls are useless becuase each value is unique
}
