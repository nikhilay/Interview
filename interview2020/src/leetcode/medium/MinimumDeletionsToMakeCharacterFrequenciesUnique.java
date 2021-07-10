package leetcode.medium;

import java.util.HashSet;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    //https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/discuss/927549/C%2B%2BJavaPython-3-Greedy
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        int deletions = 0;
        HashSet<Integer> memo = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0 && !memo.add(count[i])) {
                count[i]--;
                deletions++;
            }
        }
        return deletions;
    }
}
