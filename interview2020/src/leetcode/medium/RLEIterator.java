package leetcode.medium;

//https://leetcode.com/problems/rle-iterator/discuss/168294/Java-Straightforward-Solution-O(n)-time-O(1)-space
public class RLEIterator {
    int index;
    int[] encoding;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        index = 0;
    }

    public int next(int n) {
        //if n > encoding[index]
        while (index < encoding.length && n > encoding[index]) {
            n = n - encoding[index];
            index += 2;
        }
        if (index >= encoding.length) return -1;
        encoding[index] = encoding[index] - n;
        return encoding[index + 1];
    }
}

