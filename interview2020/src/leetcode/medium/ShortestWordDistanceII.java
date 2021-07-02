package leetcode.medium;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShortestWordDistanceII {
    HashMap<String, LinkedList<Integer>> memo;

    public ShortestWordDistanceII(String[] wordsDict) {
        memo = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (!memo.containsKey(wordsDict[i])) {
                memo.put(wordsDict[i], new LinkedList<>());
            }
            memo.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        //1 7 9 10 12
        //4, 11, 18
        List<Integer> list1 = memo.get(word1);
        List<Integer> list2 = memo.get(word2);
        int result = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            result = Math.min(result, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }


        }

        return result;
    }


}
