package leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;
    //https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find

    public FindMedianFromDataStream() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        rightHalf.offer(num);
        leftHalf.offer(rightHalf.poll());

        if(rightHalf.size() < leftHalf.size()) {
            rightHalf.offer(leftHalf.poll());
        }
    }

    public double findMedian() {
       if(leftHalf.size()==rightHalf.size()){
           return (leftHalf.peek() + rightHalf.peek())/2.0;
       }
       return rightHalf.peek();
    }
}
