package Tiktok2025.Tiktok202504;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class BestTimetoBuyandSellStockwithCooldown309M {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i == 1) {
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i-2][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }

}
