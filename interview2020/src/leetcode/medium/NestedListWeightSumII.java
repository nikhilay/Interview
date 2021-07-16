package leetcode.medium;

import java.util.List;

public class NestedListWeightSumII {
    //1x + 2y + 3z is what we have from problem 1(nested-list-weight-sum-i)
    //now we need 3x + 2y + 1z.
    //3x + 2y + 1z = 4 (x + y + z) - 1x + 2y + 3z. we will always need multiplier as (level + 1).
    //https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/114195/Java-one-pass-DFS-solution-mathematically
    int flatSum = 0;
    int maxDepth = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depthSum = helper(nestedList, 1);
        return (flatSum * (maxDepth + 1)) - depthSum;
    }

    public int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
                maxDepth = Math.max(depth, maxDepth);
                flatSum += n.getInteger();

            } else {
                sum += helper(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}
