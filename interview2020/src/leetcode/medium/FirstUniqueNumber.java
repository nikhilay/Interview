package leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/first-unique-number/discuss/601098/C%2B%2BJava-Queue-and-Unordered-Map-or-O(n)-Solution
public class FirstUniqueNumber {
    HashMap<Integer, Integer> map;
    Queue<Integer> list;
    public FirstUniqueNumber(int[] nums) {
        map = new HashMap<>();
        list = new LinkedList<>();
        for(int n: nums) {
            add(n);
        }

    }

    public int showFirstUnique() {

        while(!list.isEmpty() && map.get(list.peek())>1){
            list.poll();
        }
        return list.isEmpty()?-1:list.peek();
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        list.add(value);

    }
}
