package leetcode.medium;

//https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-swaps-to-group-red-balls-aedd07dc5cd2
public class MinimumSwapsToGroupRedBalls {
    public int minSwaps(String s) {
        char[] array = s.toCharArray();
        int redCount = 0;
        for (char c : array) {
            if (c == 'R') redCount++;
        }
        int start = 0;
        int end = s.length() - 1;
        long result = 0;

        while (start < end) {
            if (array[start] == 'R' && array[end] == 'R') {
                redCount -= 2;
                result += end - start - 1 - redCount;
            } else if (array[end] != 'R') {
                end--;
            } else {
                start++;
            }
        }
        return (int) result;

    }
}
