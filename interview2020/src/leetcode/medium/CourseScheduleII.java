package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        LinkedList<Integer>[] adjList = new LinkedList[numCourses];
        int[] result = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if (adjList[prerequisites[i][1]] == null) adjList[prerequisites[i][1]] = new LinkedList<>();
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            result[index++] = pre;
            for (int c = 0; adjList[pre] != null && c < adjList[pre].size(); c++) {
                if (--indegree[adjList[pre].get(c)] == 0) {
                    queue.offer(adjList[pre].get(c));
                }
            }
        }
        if (index != numCourses) return new int[]{};
        return result;
    }
}
