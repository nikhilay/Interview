package leetcode.easy;

public class NumberofGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int numIdenticalPairs = 0;
        int[] count = new int[101];
        for (int i : nums) {
            count[i]++;
        }

        for (int n : count) {
            numIdenticalPairs += (n * (n - 1) / 2);
        }
        return numIdenticalPairs;
    }
}
