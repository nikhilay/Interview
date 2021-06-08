package leetcode.medium;

public class GameOfLife {
    //https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation/193726
    int dead = 2;//alive to dead
    int alive = 3;//dead to alive

    public void gameOfLife(int[][] board) {


        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                int livingCount = countLivingNeighbors(board, row, col);

                if (board[row][col] == 0 && livingCount == 3) {
                    board[row][col] = alive;
                }

                if (board[row][col] == 1 && (livingCount < 2 || livingCount > 3)) {
                    board[row][col] = dead;
                }

            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == dead) {
                    board[row][col] = 0;
                }
                if (board[row][col] == alive) {
                    board[row][col] = 1;
                }
            }
        }


    }

    private int countLivingNeighbors(int[][] board, int row, int col) {

        int[][] coordinates = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int count = 0;
        for (int[] coordinate : coordinates) {
            int x = row + coordinate[0];
            int y = col + coordinate[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[row].length) {
                if (board[x][y] == 1 || board[x][y] == dead) {
                    count++;
                }
            }
        }
        return count;
    }
}
