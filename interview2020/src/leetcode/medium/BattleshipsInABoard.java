package leetcode.medium;

public class BattleshipsInABoard {
    //https://leetcode.com/problems/battleships-in-a-board/discuss/90902/Simple-Java-Solution
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) return 0;
        int count = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') continue;
                if (r > 0 && board[r - 1][c] == 'X') continue;
                if (c > 0 && board[r][c - 1] == 'X') continue;
                count++;
            }

        }
        return count;
    }
}
