package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    //https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/discuss/414172/PythonC%2B%2BJava-Set-Solution
    public int maxLength(List<String> arr) {
        int res = 0;
        if (arr == null || arr.size() == 0) return res;
        //Use only arraylist as its faster
        List<Integer> memo = new ArrayList<>();
        memo.add(0);
        for (String s : arr) {
            int word = 0;
            int dup = 0;
            for (char c : s.toCharArray()) {
                //used to determine if the word is unique
                dup = dup | (word & (1 << (c - 'a')));
                word = word | 1 << (c - 'a');
            }
            if (dup > 0) continue;

            // i can't start with 0 as the size would dynamically increase
            for (int i = memo.size() - 1; i >= 0; i--) {
                if ((memo.get(i) & word) > 0) continue;
                //adding the unique word
                memo.add(memo.get(i) | word);
                res = Math.max(res, Integer.bitCount(memo.get(i) | word));
            }
        }
        return res;
    }
}
