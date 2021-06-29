package leetcode.medium;

public class SearchA2DMatrix {
    /**
     * in b-search you always do <=, begin< end will not work.
     * Imagine there is only 1 element, start = end = 0. The search will not check that element since it fails begin<end
     */
    //https://icarus.cs.weber.edu/~dab/cs1410/textbook/7.Arrays/row_major.html
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0;
        int end = r * c - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            int val = matrix[mid / c][mid % c];
            if (val == target) {
                return true;
            } else if (target < val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return false;
    }

}
