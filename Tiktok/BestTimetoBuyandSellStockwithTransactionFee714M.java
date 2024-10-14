package Tiktok;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class BestTimetoBuyandSellStockwithTransactionFee714M {
    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0]-fee;
        for (int i = 1; i < prices.length; i++) {
            //fee只用在买入的时候添加
            dp[i][0] =Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] =Math.max(dp[i - 1][1], dp[i-1][0]-prices[i]-fee);
        }
        return dp[n - 1][0];
    }
}
