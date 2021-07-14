package leetcode.medium;

import java.util.TreeMap;

public class MyCalendarI {
    //https://www.baeldung.com/java-treemap
    //https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC%2B%2B-Clean-Code-with-Explanation
    //https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC++-Clean-Code-with-Explanation/113896
    TreeMap<Integer, Integer> map;

    public MyCalendarI() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer lowKey = map.lowerKey(end);

        if (lowKey == null || start >= map.get(lowKey)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}
