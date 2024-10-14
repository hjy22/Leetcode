package Tiktok;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimetoBuyandSellStock121E {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.print(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<prices.length;i++){
            //0-当前未持有股票，对比：这次也未持有，这次卖掉
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);

            //1-当前持有股票，对比：前一次也持有，这次第一次买
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];
    }
}
