package leetcode.hard;

public class ReadNCharactersGivenRead4II {
    char[] memo = new char[4];
    int bufPointer = 0;
    int buffCount = 0;

    // https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49598/A-simple-Java-code/157125
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (bufPointer == 0) {
                buffCount = read4(memo);
            }
            if (buffCount == 0) return ptr;

            while (ptr < n && bufPointer < buffCount) {
                buf[ptr++] = memo[bufPointer++];
            }

            if (bufPointer >= buffCount) bufPointer = 0;
        }
        return ptr;
    }

    private int read4(char[] buf4) {
        return 0;
    }

}
