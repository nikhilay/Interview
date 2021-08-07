package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    //https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76930/9~10ms-JAVA-solution-beats-98
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int buildingCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    buildingCount++;
                }
            }
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] distance = new int[m][n];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] reachCount = new int[m][n];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1)
                    if (!bfs(r, c, distance, grid, reachCount, directions, buildingCount)) {
                        return -1;
                    }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int r = 0; r < distance.length; r++) {
            for (int c = 0; c < distance[r].length; c++) {
                if (grid[r][c] == 0 && reachCount[r][c] == buildingCount) {
                    minDistance = Math.min(minDistance, distance[r][c]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private boolean bfs(int row, int col, int[][] distance, int[][] grid, int[][] reachCount,
                        int[][] directions, int buildingCount) {
        int level = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[row][col] = true;
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.poll();
                int r = tuple[0];
                int c = tuple[1];
                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow < 0 || newCol < 0 ||
                            newRow >= grid.length || newCol >= grid[0].length ||
                            grid[newRow][newCol] == 2 || visited[newRow][newCol]) continue;
                    visited[newRow][newCol] = true;
                    if (grid[newRow][newCol] == 1) {
                        count++;
                    } else {
                        queue.offer(new int[]{newRow, newCol});
                        distance[newRow][newCol] += level;
                        reachCount[newRow][newCol]++;
                    }

                }
            }
        }
        return count == buildingCount;
    }
}
