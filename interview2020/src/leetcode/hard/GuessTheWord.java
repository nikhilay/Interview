package leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GuessTheWord {
    //https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = Arrays.asList(wordlist);
        for (int chance = 1; chance <= 10; chance++) {
            int[][] count = new int[6][26];
            for (String word : words) {
                for (int i = 0; i < 6; i++) {
                    count[i][word.charAt(i) - 'a']++;
                }
            }
            int high = 0;
            String guess = "";
            for (String word : words) {
                int score = 0;
                for (int i = 0; i < 6; i++) {
                    score += count[i][word.charAt(i) - 'a'];
                }
                if (score > high) {
                    high = score;
                    guess = word;
                }
            }

            int match = master.guess(guess);
            List<String> newList = new LinkedList<>();
            for (String word : words) {

                if (similarityScore(word, guess) == match) {
                    newList.add(word);
                }
            }
            words = newList;
        }
    }

    private int similarityScore(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) count++;
        }
        return count;
    }
}


interface Master {
    public default int guess(String word) { return 1;}
}
