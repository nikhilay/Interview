package leetcode.medium;

public class UniqueBinarySearchTrees {
    //https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        //This for loop is for going from 1 node to n nodes
        for (int i = 2; i <= n; i++) {
            //This for loop is for making each node as center
            for (int j = 1; j <= i; j++) {
                memo[i] += memo[j - 1] * memo[i - j];
            }


        }
        return memo[n];

    }
}
