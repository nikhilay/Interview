package leetcode.medium;

public class RangeAddition {
    //https://leetcode.com/problems/range-addition/discuss/84217/Java-O(K-%2B-N)time-complexity-Solution
    //https://leetcode.com/problems/range-addition/discuss/84217/Java-O(K-+-N)time-complexity-Solution/88593
    public int[] getModifiedArray(int length, int[][] updates) {

        if (updates == null || updates.length == 0) return null;
        int[] result = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            result[start] += val;
            if (end < length - 1) result[end + 1] -= val;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}
