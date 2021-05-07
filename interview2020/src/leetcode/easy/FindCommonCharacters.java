package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    //https://leetcode.com/problems/find-common-characters/discuss/259707/Java-Clean-Solution
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int min = Integer.MAX_VALUE;
            for (String s : A) {
                int letterCount = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ch) {
                        letterCount++;
                    }
                }
                min = Math.min(letterCount, min);
            }
            for (int i = 1; i <= min; i++) {
                result.add(String.valueOf(ch));
            }
        }
        return result;
    }
}
