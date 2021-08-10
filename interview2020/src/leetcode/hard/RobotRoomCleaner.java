package leetcode.hard;

import java.util.HashSet;

//https://leetcode.com/problems/robot-room-cleaner/discuss/153530/DFS-Logical-Thinking
public class RobotRoomCleaner {

    public void cleanRoom(Robot robot) {
        int[][] directions = {{-1,0}, {0,1},{1,0},{0,-1}};
        dfs(robot, 0, 0, 0, new HashSet<>(), directions);
    }

    private void dfs(Robot robot, int row, int col, int dir, HashSet<String> visited, int[][] directions) {
        robot.clean();
        visited.add(row + " " + col);

        for (int d = dir; d < dir + 4; d++) {
            int newRow = row + directions[d % 4][0];
            int newCol = col + directions[d % 4][1];
            if (!visited.contains(newRow + " " + newCol) && robot.move()) {
                dfs(robot, newRow, newCol, d % 4, visited, directions);
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
