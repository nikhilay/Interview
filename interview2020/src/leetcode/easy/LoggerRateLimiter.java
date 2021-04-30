package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    Map<String, Integer> stringTimeMap;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        stringTimeMap = new HashMap<>();

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if(stringTimeMap.containsKey(message)){
            if (timestamp - stringTimeMap.get(message) >= 10){
                stringTimeMap.put(message,timestamp);
                return true;
            }
            return false;
        }

        stringTimeMap.put(message,timestamp);
        return true;

    }
}
