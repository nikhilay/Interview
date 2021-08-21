package leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    // data repition
    //https://leetcode.com/problems/maximum-frequency-stack/discuss/163410/C%2B%2BJavaPython-O(1)
    // My solution sequence number + Priority queue + comparator + list of indices map
    //problem integer overflow
    //https://leetcode.com/problems/maximum-frequency-stack/discuss/163416/Java-Priority-Queue-easy-understand

    Map<Integer, Stack<Integer>> position;
    Map<Integer, Integer> freq;
    int maxFrequency = 0;

    public MaximumFrequencyStack() {
        position = new HashMap<>();
        freq = new HashMap<>();
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (position.get(f) == null) {
            position.put(f, new Stack<>());
        }
        position.get(f).add(val);
        maxFrequency = Math.max(maxFrequency, f);
    }

    public int pop() {
        int x = position.get(maxFrequency).pop();
        freq.put(x, maxFrequency - 1);
        if (position.get(maxFrequency).size() == 0) maxFrequency--;
        return x;

    }
}
