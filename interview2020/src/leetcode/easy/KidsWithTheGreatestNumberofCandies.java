package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class KidsWithTheGreatestNumberofCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        List<Boolean> output = new LinkedList<>();
        for (int i: candies){
            maxCandies =  Math.max(maxCandies, i);
        }
        for(int i : candies){
            output.add(i + extraCandies >= maxCandies);
        }
        return output;
    }
}
