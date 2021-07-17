package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    //https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/312706/JAVA-BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        int result = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1},{-1, -1}, {1, -1}, {-1, 1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            System.out.println("nikhil");
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coordinates = queue.poll();
                int r = coordinates[0];
                int c = coordinates[1];
                if (r == m - 1 && c == n - 1) return result + 1;
                visited[r][c] = true;
                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] != 1) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }

            }
            result++;
        }
        return -1;
    }
}
