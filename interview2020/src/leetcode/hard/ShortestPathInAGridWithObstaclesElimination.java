package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
    //https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/451796/Java-Straightforward-BFS-O(MNK)-time-or-O(MNK)-space
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                int r = coordinate[0];
                int c = coordinate[1];
                int currK = coordinate[2];
                if (r == m - 1 && c == n - 1) return res;
                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    int newK = currK;
                    if (newR >= 0 && newC >= 0 && newR < m && newC < n && !visited[newR][newC][newK]) {
                        if (grid[newR][newC] == 1) {
                            newK++;
                        }
                        if (newK <= k && !visited[newR][newC][newK]) {
                            visited[newR][newC][newK] = true;
                            queue.offer(new int[]{newR, newC, newK});
                        }

                    }
                }
            }
            res++;
        }
        return -1;

    }
}
