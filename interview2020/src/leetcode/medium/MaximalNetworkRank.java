package leetcode.medium;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        int[] outdegree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            outdegree[city1]++;
            outdegree[city2]++;
            connected[city1][city2] = true;
            connected[city2][city1] = true;

        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = outdegree[i] + outdegree[j] - (connected[i][j] ? 1 : 0);
                max = Math.max(max, rank);
            }
        }
        return max;
    }
}
