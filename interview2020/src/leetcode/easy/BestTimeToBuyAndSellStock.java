package leetcode.easy;

public class BestTimeToBuyAndSellStock {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-%3A)-(In-case-if-interviewer-twists-the-input)
    public int maxProfit(int[] prices) {
        int currentMax = 0;
        int totalMax = 0;

        for(int i=1;i<prices.length;i++){
            currentMax = Math.max(currentMax+ prices[i] - prices[i-1],0);
            totalMax = Math.max(currentMax,totalMax);
        }
    return totalMax;
    }
}
