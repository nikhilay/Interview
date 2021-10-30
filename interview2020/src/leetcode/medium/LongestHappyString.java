package leetcode.medium;

public class LongestHappyString {

    //https://leetcode.com/problems/longest-happy-string/discuss/564273/Java-Happy-Greedy-String-without-PQ
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int len = a + b + c;
        int countA = 0;
        int countB = 0;
        int countC = 0;

        for (int i = 0; i < len; i++) {
            // three conditions
            // 1. We have just started counting and a has the highest frequency
            // 2. countB has reached 2 and now they want to fit in `a` or `c` and if a>0. we can use a
            // 3.  countC has reached 2 and now they want to fit in `a` or `b` and if a>0. we can use a
            if ((a >= b && a >= c && countA != 2)|| (countB == 2 && a > 0) || (countC == 2 && a > 0)) {
                sb.append('a');
                a--;
                countA++;
                countB = 0;
                countC = 0;


            } else if ((b >= a && b >= c && countB != 2) || (countA == 2 && b > 0) || (countC == 2 && b > 0)) {
                sb.append('b');
                b--;
                countB++;
                countA = 0;
                countC = 0;

            } else if ((c >= a && c >= b && countC != 2) || (countA == 2 && c > 0) || (countB == 2 && c > 0)) {
                sb.append('c');
                c--;
                countC++;
                countA = 0;
                countB = 0;

            }

        }
        return sb.toString();

    }

}
