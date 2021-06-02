package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    //https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
    //https://leetcode.com/problems/word-break/discuss/169383/solved-The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(wordDict);

        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && hashSet.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[memo.length - 1];
    }
}
