package leetcode.medium;

import java.util.*;

public class TopKFrequentWords {
    //https://leetcode.com/problems/top-k-frequent-words/discuss/108346/My-simple-Java-solution-using-HashMap-and-PriorityQueue-O(nlogk)-time-and-O(n)-space
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String s : words) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(frequencyMap.get(o1)==frequencyMap.get(o2)){
                    return  o1.compareTo(o2);
                }
                return frequencyMap.get(o2) - frequencyMap.get(o1);
            }
        });
        pq.addAll(frequencyMap.keySet());
        List<String> result = new LinkedList<>();
        for(int i= 0;i<k;i++){
            if(!pq.isEmpty())  result.add(pq.poll());

        }
        return result;
    }
}
