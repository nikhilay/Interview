package leetcode.medium;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();

        for (List<String> journey : tickets) {
            String from = journey.get(0);
            String to = journey.get(1);
            if (!adjList.containsKey(from)) adjList.put(from, new PriorityQueue<>());
            adjList.get(from).add(to);
        }
        System.out.println(adjList.size());
        List<String> result = new LinkedList<>();
        dfs("JFK", adjList, result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> adjList, List<String> result) {
        while (adjList.containsKey(airport) && !adjList.get(airport).isEmpty()) {
            String city = adjList.get(airport).poll();
            dfs(city, adjList, result);
        }
        result.add(0, airport);

    }
}
