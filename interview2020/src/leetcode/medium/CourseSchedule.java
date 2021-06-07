package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        boolean[][] adjMatrix = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            adjMatrix[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            for (int c = 0; c < adjMatrix[pre].length; c++) {
                if (adjMatrix[pre][c]) {
                    if (--indegree[c] == 0) {
                        queue.offer(c);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) return true;

        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if (adjList[prerequisites[i][1]] == null) {
                adjList[prerequisites[i][1]] = new ArrayList<>();
            }
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            for (int c = 0; adjList[pre]!=null && c < adjList[pre].size(); c++) {
                if (--indegree[adjList[pre].get(c)] == 0) {
                    queue.offer(adjList[pre].get(c));
                }
            }
        }
        return count == numCourses;

    }
}
