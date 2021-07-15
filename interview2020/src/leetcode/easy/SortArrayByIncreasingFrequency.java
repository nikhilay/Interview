package leetcode.easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SortArrayByIncreasingFrequency {
    //https://leetcode.com/problems/sort-array-by-increasing-frequency/discuss/917795/C++Python-Sort/940684
    public int[] frequencySort(int[] nums) {
        if (nums == null) return null;
        HashMap<Integer, Integer> memo = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) {
            memo.put(n, memo.getOrDefault(n, 0) + 1);
            list.add(n);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int f1 = memo.get(o1);
                int f2 = memo.get(o2);
                if(f1!=f2) return f1-f2;
                return o2 -o1;
            }
        });

        for(int i=0;i<nums.length;i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
