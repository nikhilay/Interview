package leetcode.medium;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int result = leftSum;
        int rightSum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            leftSum = leftSum - cardPoints[k - i - 1];
            rightSum = rightSum + cardPoints[n - 1 - i];
            result = Math.max(result, leftSum + rightSum);
        }
        return result;

    }
}
