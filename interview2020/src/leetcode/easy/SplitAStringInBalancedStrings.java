package leetcode.easy;

public class SplitAStringInBalancedStrings {
    //https://leetcode.com/problems/split-a-string-in-balanced-strings/discuss/403836/C%2B%2BJavaPython-Easy-Solution
    public int balancedStringSplit(String s) {
        int numberOfSplits = 0;
        int count = 0;

        for(int i =0; i<s.length(); i++){
            count += s.charAt(i) == 'L'?1:-1;
            if(count == 0) ++numberOfSplits;
        }
        return numberOfSplits;
    }
}
