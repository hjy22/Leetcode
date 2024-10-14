package Tiktok;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//有一天的冷冻期
public class BestTimetoBuyandSellStockwithCooldown309M {
    public static void main(String[] args) {
        int[] prices = { 1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(i==1){
                //i==1，第一次买
                dp[i][0] =Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] =Math.max(dp[i - 1][1], -prices[i]);
            }else{
                dp[i][0] =Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                //昨天也持有 vs 今天购入，但是需要在i-2前不持有的情况下买入
                dp[i][1] =Math.max(dp[i - 1][1], dp[i - 2][0]-prices[i]);
            }
            
        }
        return dp[n - 1][0];
    }
}
