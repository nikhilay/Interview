package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class SparseVector {
    List<int[]> pairs;

    SparseVector(int[] nums) {
        pairs = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) pairs.add(new int[]{i, nums[i]});
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int p = 0;
        int v = 0;
        int sum = 0;
        while (p < pairs.size() && v < vec.pairs.size()) {

            if (pairs.get(p)[0] == vec.pairs.get(v)[0]) {
                sum += (pairs.get(p)[1] * vec.pairs.get(v)[1]);
                p++;
                v++;
            } else if (pairs.get(p)[0] < vec.pairs.get(v)[0]) {
                p++;
            } else {
                v++;
            }

        }
        return sum;
    }
}
