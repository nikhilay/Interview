package leetcode.medium;

import java.util.HashMap;

public class ContinuousSubarraySum {
    //https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
    //https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space/103585
    /*

Read More
@ohuohuo This is one of those magics of remainder theorem :)

(a+(n*x))%x is same as (a%x)

For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the
remainders are [5,1,1,5,0]. We got remainder 5 at index 0 and at index 3. That means, in
between these two indexes we must have added a number which is multiple of the k. Hope this
 clarifies your doubt :)
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2) return false;
        HashMap<Integer, Integer> memo = new HashMap<>();
        //[23,2,4,6,6]
        //7
        memo.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            runningSum %= k;
            if (memo.containsKey(runningSum)) {
                if (i - memo.get(runningSum) > 1) return true;
            } else {
                memo.put(runningSum, i);
            }

        }

        return false;
    }
}
