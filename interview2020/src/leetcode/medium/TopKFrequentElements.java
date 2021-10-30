package leetcode.medium;

import java.util.*;

public class TopKFrequentElements {
    //https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums){
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return frequencyMap.get(o2) - frequencyMap.get(o1);
            }
        });
        pq.addAll(frequencyMap.keySet());
        int size = Math.min(k, pq.size());
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
