package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int[] location = new int[2];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '*') {
                    location[0] = r;
                    location[1] = c;
                }
            }
        }

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(location);
        int distance = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir :directions){
                    int newRow = dir[0] + curr[0];
                    int newCol = dir[1] + curr[1];

                    if (newRow < 0 || newCol < 0 || newRow>=grid.length || newCol>=grid[0].length
                            || grid[newRow][newCol]=='X' || visited[newRow][newCol]) continue;

                    if(grid[newRow][newCol]=='#') return distance;
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow,newCol});
                }

            }

        }
        return -1;

    }
}
