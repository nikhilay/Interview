package leetcode.medium;

import java.util.Random;
//https://leetcode.com/problems/random-pick-with-weight/solution/
public class RandomPickWithWeight {
    Random random;
    int[] weightedSum;

    public RandomPickWithWeight(int[] w) {
        weightedSum = w;
        random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
    }

    public int pickIndex() {
        int num = random.nextInt(weightedSum[weightedSum.length - 1]) + 1;
        int low = 0;
        int high = weightedSum.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (weightedSum[mid] == num) {
                return mid;
            } else if (weightedSum[mid] < num) {
                low++;
            } else {
                high--;
            }
        }
     return low;
    }

}
