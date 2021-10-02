package leetcode.medium;

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int curr = 0;
        for (int r = 0; r < rows; r++) {
            int tmp = cols;
            while (curr < sentence.length) {
                if (sentence[curr].length() + 1 <= tmp + 1) {
                    tmp -= sentence[curr].length() + 1;
                    curr++;
                    if (curr == sentence.length) {
                        curr = 0;
                        count++;
                    }

                } else {
                    break;
                }
            }
        }
        return count;
    }
}
