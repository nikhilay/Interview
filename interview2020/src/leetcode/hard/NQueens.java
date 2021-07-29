package leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    //https://leetcode.com/problems/n-queens/solution/
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        char[][] state = new char[n][n];
        for (int r = 0; r < state.length; r++) {
            for (int c = 0; c < state[r].length; c++) {
                state[r][c] = '.';
            }
        }
        backtracking(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n, state, result);
        return result;
    }

    private void backtracking(int row, HashSet<Integer> cols,
                              HashSet<Integer> diagonals,
                              HashSet<Integer> antiDiagonals, int n,
                              char[][] state,
                              List<List<String>> result) {
        //add Result
        if (row == n) {
            LinkedList res = new LinkedList();
            for (char[] r : state) {
                res.add(String.valueOf(r));
            }
            result.add(res);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal = col - row;
            int antiDiagonal = col + row;
            if (cols.contains(col) ||
                    diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }
            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);
            state[row][col] = 'Q';

            backtracking(row + 1, cols, diagonals, antiDiagonals, n, state, result);

            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
            state[row][col] = '.';
        }

    }

}
