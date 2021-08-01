package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PalindromePairs {
    //https://leetcode.com/problems/palindrome-pairs/discuss/79210/The-Easy-to-unserstand-JAVA-Solution
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) return null;

        List<List<Integer>> result = new LinkedList<>();
        HashMap<String, Integer> hmap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            hmap.put(words[i], i);
        }

        if (hmap.containsKey("")) {
            int emptyStringIndex = hmap.get("");
            for (int i = 0; i < words.length; i++) {
                if (emptyStringIndex != i && isPalindrome(words[i])) {
                    result.add(Arrays.asList(i, emptyStringIndex));
                    result.add(Arrays.asList(emptyStringIndex, i));
                }
            }
        }

        //words Of equal length
        for (int i = 0; i < words.length; i++) {
            if (hmap.containsKey(words[i])) {
                String reverseWord = reverseWord(words[i]);
                if (hmap.containsKey(reverseWord) && hmap.get(reverseWord) != i) {
                    result.add(Arrays.asList(i, hmap.get(reverseWord)));
                }
            }
        }

        //Words Of Unequal Length
        for (int i = 0; i < words.length; i++) {
            for(int cut = 1; cut<words[i].length(); cut++){
                if(isPalindrome(words[i].substring(cut))){
                    String word = reverseWord(words[i].substring(0,cut));
                    if(hmap.containsKey(word)){
                        int found = hmap.get(word);
                        if(found==i) continue;
                        result.add(Arrays.asList(i,found));
                    }
                }
                if(isPalindrome(words[i].substring(0,cut))){
                    String word = reverseWord(words[i].substring(cut));
                    if(hmap.containsKey(word)){
                        int found = hmap.get(word);
                        if(found==i) continue;
                        result.add(Arrays.asList(found, i));
                    }
                }

            }

        }


        return result;
    }

    private String reverseWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start <= end) {
            if (word.charAt(start) != word.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
