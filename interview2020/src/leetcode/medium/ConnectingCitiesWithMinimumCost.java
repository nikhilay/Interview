package leetcode.medium;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {
    //https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/357446/Simple-Java-solution-for-slow-learners-like-myself
    public int minimumCost(int n, int[][] connections) {
        if (connections == null || connections.length == 0) return -1;
        if (n == 1) return 0;
        LinkedList<int[]>[] adjacencyList = new LinkedList[n + 1];
        for (int[] connection : connections) {
            int city1 = connection[0];
            int city2 = connection[1];
            int cost = connection[2];

            if (adjacencyList[city1] == null) adjacencyList[city1] = new LinkedList();
            if (adjacencyList[city2] == null) adjacencyList[city2] = new LinkedList();
            adjacencyList[city1].add(new int[]{city2, cost});
            adjacencyList[city2].add(new int[]{city1, cost});
        }
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //first visit
        pq.offer(new int[]{1, 0});
        int numberOfCitiesVisited = 0;
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] city = pq.poll();
            if (visited[city[0]]) continue;
            visited[city[0]] = true;
            numberOfCitiesVisited++;
            cost += city[1];

            for (int[] destination : adjacencyList[city[0]]) {
                if (!visited[destination[0]]) pq.offer(destination);
            }
        }
        return numberOfCitiesVisited == n ? cost : -1;
    }

}
