package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char number = board[r][c];
                if (board[r][c] != '.') {
                    if (!seen.add(number + " in row " + r)
                            || !seen.add(number + " in col " + c)
                            || !seen.add(number + " in cube " + r / 3 + " - " + c / 3)) return false;
                }
            }
        }

        return true;
    }
}
