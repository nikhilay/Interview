package leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int n : arr) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (int n : count.keySet()) {
            if(count.get(n)==0) continue;
            int want = n < 0 ? n / 2 : n * 2;
            if ((n < 0 && n % 2 !=0) || (count.get(n) > count.getOrDefault(want, 0))) {
                return false;
            }
            count.put(want, count.get(want) - count.get(n));
        }
        return true;
    }
}
