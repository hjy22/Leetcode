package DP;

//https://leetcode.com/problems/coin-change-ii/
public class CoinChangeII518M {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
