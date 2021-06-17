package leetcode.medium;

import java.util.LinkedList;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int count = 0;
        LinkedList<Integer>[] adjList = new LinkedList[n];

        for (int[] edge : edges) {
            int origin = edge[0];
            int dest = edge[1];
            if (adjList[origin] == null) adjList[origin] = new LinkedList<>();
            if (adjList[dest] == null) adjList[dest] = new LinkedList<>();
            adjList[origin].add(dest);
            adjList[dest].add(origin);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adjList, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(LinkedList<Integer>[] adjList, boolean[] visited, int node) {
        if (visited[node]) return;
        visited[node] = true;
        if (adjList[node] != null) {
            for (int n : adjList[node]) {
                dfs(adjList, visited, n);
            }
        }

    }
}
