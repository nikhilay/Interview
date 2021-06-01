package leetcode.medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int maxSubString = 0;
        int j =0 ;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(hmap.containsKey(c)){
                j = Math.max(j, hmap.get(c) +1);

            }
            hmap.put(c, i);
            maxSubString = Math.max(maxSubString , i - j +1);

        }
    return maxSubString;
    }
}
