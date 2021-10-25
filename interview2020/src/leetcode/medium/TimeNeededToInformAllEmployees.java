package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager == null || informTime == null) return -1;
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (!map.containsKey(manager[i])) map.put(manager[i], new LinkedList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(map, informTime, headID);

    }

    private int dfs(Map<Integer, LinkedList<Integer>> map, int[] informTime, int curr) {
       if(!map.containsKey(curr)) return 0 ;
       int max = 0;
        for (int employee : map.get(curr)) { ;
            max = Math.max(max, dfs(map,informTime, employee));
        }

        return max +  informTime[curr];
    }
}
