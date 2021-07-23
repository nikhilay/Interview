package leetcode.hard;

public class SudokuSolver {
    //https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
    //Complexity Analysis
    //
    //Time complexity is constant here since the board size is fixed and there is no N-parameter to measure. Though let's discuss the number of operations needed : (9!)^9(9!)
    //9
    // . Let's consider one row, i.e. not more than 99 cells to fill. There are not more than 99 possibilities for the first number to put, not more than 9 \times 89×8 for the second one, not more than 9 \times 8 \times 79×8×7 for the third one etc. In total that results in not more than 9!9! possibilities for a just one row, that means not more than (9!)^9(9!)
    //9
    //  operations in total. Let's compare:
    //
    //9^{81} = 1966270504755529136180759085269121162831034509442147669273154155379663911968099
    //81
    // =196627050475552913618075908526912116283103450944214766927315415537966391196809 for the brute force,
    //
    //and (9!)^9 = 109110688415571316480344899355894085582848000000000(9!)
    //9
    // =109110688415571316480344899355894085582848000000000 for the standard backtracking, i.e. the number of operations is reduced in 10^{27}10
    //27
    //  times !
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') {
                    for (char n = '1'; n <= '9'; n++) {
                        if (isValid(board, r, c, n)) {
                            board[r][c] = n;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[r][c] = '.';
                            }
                        }

                    }
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == num) return false;
            if (board[i][col] != '.' && board[i][col] == num) return false;
            if (board[(3 * (row / 3)) + i / 3][(3 * (col / 3)) + i % 3] != '.' && board[(3 *
                    (row / 3)) + i / 3][(3 * (col / 3)) + i % 3] == num)
                return false;
            ;
        }
        return true;
    }
}
