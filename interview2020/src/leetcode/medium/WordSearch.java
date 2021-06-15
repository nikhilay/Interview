package leetcode.medium;

public class WordSearch {
    /**
     * Complexity Analysis
     * <p>
     * Time Complexity: \mathcal{O}(N \cdot 3 ^ L)O(N⋅3
     * L
     * ) where NN is the number of cells in the board and LL is the length of the word to be matched.
     * <p>
     * For the backtracking function, initially we could have at most 4 directions to explore, but further the choices
     * are reduced into 3 (since we won't go back to where we come from). As a result, the execution trace after the
     * first step could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the
     * corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of
     * nodes in a full 3-nary tree, which is about 3^L3
     * L
     * .
     * <p>
     * We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking
     * function in the worst case.
     * <p>
     * As a result, overall the time complexity of the algorithm would be \mathcal{O}(N \cdot 3 ^ L)O(N⋅3
     * L
     * ).
     * <p>
     * Space Complexity: \mathcal{O}(L)O(L) where LL is the length of the word to be matched.
     * <p>
     * The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length
     * of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is
     * \mathcal{O}(L)O(L).
     */
    //https://leetcode.com/problems/word-search/solution/
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (exist(board, word.toCharArray(), row, col, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] word, int row, int col, int index) {
        if (index == word.length) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] != word[index])
            return false;
        board[row][col] ^= 256;
        boolean wordExist = exist(board, word, row + 1, col, index + 1)
                || exist(board, word, row - 1, col, index + 1)
                || exist(board, word, row, col + 1, index + 1)
                || exist(board, word, row, col - 1, index + 1);
        board[row][col] ^= 256;
        return wordExist;
    }
}
