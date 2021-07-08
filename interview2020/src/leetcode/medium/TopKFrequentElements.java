package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TopKFrequentElements {
    //https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        List<Integer> result = new LinkedList<>();

        for (int n : nums) frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        for (int key : frequencyMap.keySet()) {
            if (bucket[frequencyMap.get(key)] == null) {
                bucket[frequencyMap.get(key)] = new LinkedList<Integer>();
            }
            bucket[frequencyMap.get(key)].add(key);
        }
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if(bucket[i]!=null) result.addAll(bucket[i]);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);

        }
        return res;
    }
}
