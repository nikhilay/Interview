package leetcode.hard;

import java.util.LinkedList;
import java.util.List;

public class WordSearch2 {
    //https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    //https://leetcode.com/problems/word-search-ii/solution/
    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> res = new LinkedList<>();
        buildTrieTree(words);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                dfs(root,board, r, c, res);

            }
        }
        return res;
    }

    private void dfs(TrieNode node,char[][] board, int row, int col, List<String> res) {
        char c = board[row][col];
        if(c=='#' || node.children[c-'a']==null){
            return;
        }
        node = node.children[c-'a'];
        if(node.word!=null) {
            res.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';
        if(row>0) dfs(node, board, row -1, col, res);
        if(col>0) dfs(node, board, row, col -1 , res);
        if(row < board.length - 1) dfs(node, board, row + 1, col, res);
        if(col <board[row].length -1 ) dfs(node, board, row, col + 1, res);
        board[row][col] = c;


    }

    private void buildTrieTree(String[] words) {
        for (String word : words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.word = word;
        }
    }

    public class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
