package leetcode.hard;

import java.util.*;

public class EmployeeFreeTime {
    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new LinkedList<>();
        if (schedule == null || schedule.size() == 0) return result;
        List<Interval> queue = new LinkedList<>();
        for (List<Interval> employee : schedule) {
            queue.addAll(employee);
        }
        Collections.sort(queue, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Interval tmp  = queue.get(0);
        for(Interval interval : queue){
            System.out.println(interval.start + ", " + interval.end);
            if(interval.start <= tmp.end){
                tmp.end = Math.max(tmp.end, interval.end);
            } else{
                result.add(new Interval(tmp.end,interval.start));
                tmp = interval;
            }
        }
        return result;
    }
}
