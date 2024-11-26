package Google;

public class CoinChange322M {
    public static void main(String[] args) {
        int[] coins = { 1,2,5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    // https://leetcode.com/problems/coin-change/
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int coin:coins){
                if (i - coin < 0 || dp[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i]=Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return (dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
    }
}