package leetcode.easy;

public class CountNegativeNumbersInASortedMatrix {
    //https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/discuss/510249/JavaPython-3-2-similar-O(m-%2B-n)-codes-w-brief-explanation-and-analysis.
    public int countNegatives(int[][] grid) {
        int rowLength = grid[0].length;
        int colLength = grid.length;
        int r = colLength - 1;
        int c = 0;
        int count = 0;
        while (r >= 0 && c < rowLength) {
            if (grid[r][c] < 0) {
                r--;
                count += rowLength - c;
            } else {
                c++;
            }
        }
    return count;
    }
}
