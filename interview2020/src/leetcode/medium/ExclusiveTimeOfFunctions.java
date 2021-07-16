package leetcode.medium;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    //https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space
    //https://leetcode.com/problems/exclusive-time-of-functions/discuss/105084/How-is-function-1-executing-4-units-of-time
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result =  new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for(String log : logs){
            String[] logArray = log.split(":");
            if(!stack.isEmpty()) result[stack.peek()] += Integer.valueOf(logArray[2]) - prevTime;
            prevTime = Integer.valueOf(logArray[2]);
            if(logArray[1].equals("start")) stack.push(Integer.valueOf(logArray[0]));
            if(logArray[1].equals("end")){
                prevTime++;
                result[stack.pop()]++;
            }

        }
        return result;
    }
}
