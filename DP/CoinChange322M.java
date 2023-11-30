package DP;

//https://leetcode.com/problems/coin-change/
public class CoinChange322M {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount + 1];
        ans[0] = 0;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = amount + 1;
            int sum = i;
            for (int j = 0; j < coins.length; j++) {
                if (sum >= coins[j]) {
                    ans[i] = Math.min(ans[i], ans[sum-coins[j]]+1);
                }
            }
        }
        int minCoin = ans[amount];
        if(minCoin==amount + 1){
            return -1;
        }else{
            return minCoin;
        }
    }
}
