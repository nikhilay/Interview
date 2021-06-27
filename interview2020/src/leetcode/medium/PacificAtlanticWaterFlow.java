package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    //https://leetcode.com/problems/pacific-atlantic-water-flow/solution/
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();
        if (heights == null || heights.length == 0) return result;
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int r = 0; r < heights.length; r++) {
            pacificQueue.offer(new int[]{r, 0});
            atlanticQueue.offer(new int[]{r, heights[r].length - 1});
        }
        for (int c = 0; c < heights[0].length; c++) {
            pacificQueue.offer(new int[]{0, c});
            atlanticQueue.offer(new int[]{heights.length - 1, c});
        }
        boolean[][] pacificReachable = bfs(heights, pacificQueue);
        boolean[][] atlanticReachable = bfs(heights, atlanticQueue);

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private boolean[][] bfs(int[][] heights, Queue<int[]> queue) {
        boolean[][] reachable = new boolean[heights.length][heights[0].length];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            reachable[point[0]][point[1]] = true;
            for (int[] dir : directions) {
                int r = point[0] + dir[0];
                int c = point[1] + dir[1];
                if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length) continue;
                if (reachable[r][c]) continue;
                if (heights[point[0]][point[1]] > heights[r][c]) continue;
                queue.offer(new int[]{r, c});
            }


        }
        return reachable;
    }
}
