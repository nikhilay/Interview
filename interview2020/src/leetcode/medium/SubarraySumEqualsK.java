package leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int subArrayCount = 0;
        if (nums == null || nums.length == 0) return subArrayCount;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) subArrayCount++;
            }
        }
        return subArrayCount;
    }
//https://leetcode.com/problems/subarray-sum-equals-k/discuss/?currentPage=1&orderBy=most_votes&query=
    public int subarraySum2(int[] nums, int k) {
        int subArrayCount = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        if (nums == null || nums.length == 0) return subArrayCount;
        hmap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hmap.containsKey(sum - k)){
                subArrayCount+=hmap.get(sum-k);
            }

            hmap.put(sum, hmap.getOrDefault(sum,0)+1);
        }
        return subArrayCount;
    }
}

