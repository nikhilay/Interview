package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CriticalConnectionsInANetwork {
    //https://leetcode.com/problems/critical-connections-in-a-network/solution/
    //https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/DFS-detailed-explanation-O(orEor)-solution
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List[] adjList = new ArrayList[n];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (List<Integer> edge : connections) {
            adjList[edge.get(0)].add(edge.get(1));
            adjList[edge.get(1)].add(edge.get(0));
        }
        Integer[] rank = new Integer[n];
        HashSet<List<Integer>> connectionsSet = new HashSet<>(connections);
        dfs(adjList, 0, 0, connectionsSet, rank);
        return new ArrayList<>(connectionsSet);
    }

    private int dfs(List<Integer>[] adjList, int node, int depth, HashSet<List<Integer>> connectionsSet, Integer[] rank) {
        if (rank[node] != null && rank[node] >= 0) return rank[node];
        rank[node] = depth;
        int overallMinDepth = depth;
        for (Integer neighbor : adjList[node]) {
            // we have to skip parent
            if (rank[neighbor] != null && rank[neighbor]== depth - 1) continue;
            int minDepth = dfs(adjList, neighbor, depth + 1, connectionsSet, rank);
            overallMinDepth = Math.min(overallMinDepth, minDepth);
            if (minDepth <= depth) {
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return overallMinDepth;
    }
}
