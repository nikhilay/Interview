package leetcode.medium;

public class countNumberOfTeams {
    //https://leetcode.com/problems/count-number-of-teams/discuss/555441/JavaC%2B%2B-100-O(N2)-Easy-To-Understand-With-Explanation
    public int numTeams(int[] rating) {
        int count = 0;
        for (int curr = 0; curr < rating.length; curr++) {
            int leftSmaller = 0;
            int rightBigger = 0;
            int leftBigger = 0;
            int rightSmaller = 0;

            for (int l = 0; l < curr; l++) {
                if (rating[l] > rating[curr]) {
                    leftBigger++;

                } else if (rating[l] < rating[curr]) {
                    leftSmaller++;
                }

            }

            for (int r = curr + 1; r < rating.length; r++) {
                if (rating[r] > rating[curr]) {
                    rightBigger++;

                } else if (rating[r] < rating[curr]) {
                    rightSmaller++;
                }
            }
            count += leftSmaller * rightBigger + leftBigger * rightSmaller;
        }

    return count;
    }
}
