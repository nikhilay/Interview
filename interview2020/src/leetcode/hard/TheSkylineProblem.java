package leetcode.hard;

import java.util.*;

public class TheSkylineProblem {
    //https://www.youtube.com/watch?v=GSBLe8cKu0s&ab_channel=TusharRoy-CodingMadeSimple
    //https://leetcode.com/problems/the-skyline-problem/discuss/61193/Short-Java-solution
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> result = new LinkedList<>();
        List<int[]> startEndPairs = new LinkedList<>();

        for (int[] pair : buildings) {
            startEndPairs.add(new int[]{pair[0], pair[2]});
            startEndPairs.add(new int[]{pair[1], -pair[2]});
        }

        //Lets sort based on start/end , and building heights
//Very good and concise solution. Especially that approach to mark the height as negative for all the left coordinates deserves an upvote. Here is an explanation to your approach for easy understanding:
//
//Store all the coordinate values in height arraylist and mark the height of each start/left coordinate as negative. We'll discuss it why.
//
//Sort the height array such that it considers following conditions:
//i. When the two points are not equal then sort them by coordinate values.
//ii. When two coordinate values are same, then check
//a. if both of them are start/left coordinates. If so, consider the largest height. 
//b. if both of them are end/right coordinates. If so, consider the shortest height.
//c. If one of them is end/right and other is start/left then consider the start/left height.
//
//Iterate height arraylist and store height values in the priority queue (reverse ordered) only if current coordinate is a left/start coordinate. Remove a height values from the queue if we encounter a right/end coordinate.
//
//Check if the maximum height changes in queue after each iteration. If so then add current maxheight and current coordinate to result array.
        Collections.sort(startEndPairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        pq.offer(0);
        int prev = 0;
        for (int[] pair : startEndPairs) {
            int h = pair[1];
            if (h > 0) {
               pq.offer(h);
            } else{
                pq.remove(-h);

            }
            int maxHeight = pq.peek();
            if(prev!=maxHeight){
                List<Integer> resPair = new LinkedList();
                resPair.add(pair[0]);
                resPair.add(maxHeight);
                result.add( resPair);
                prev = maxHeight;
            }
        }

        return result;
    }
}
