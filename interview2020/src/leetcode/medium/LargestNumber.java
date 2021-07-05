package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    //https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] numsString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;

                return s2.compareTo(s1);
            }
        });

        if(numsString[0].charAt(0)=='0') return "0";
        for (String s : numsString) {
            sb.append(s);
        }
        return sb.toString();
    }

}
