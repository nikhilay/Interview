package leetcode.easy;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int priceDiff = prices[i] - prices[i - 1];
            if (priceDiff > 0) profit += priceDiff;
        }
        return profit;
    }
}
