package Tiktok2025.Tiktok202504;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class CoinChange322M {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] coinNum = new int[amount+1];
        Arrays.fill(coinNum, Integer.MAX_VALUE);
        coinNum[0]=0;
        for(int i=1;i<coinNum.length;i++){
            for(int coin:coins){
                if(i-coin>=0&&coinNum[i-coin]!=Integer.MAX_VALUE){
                    coinNum[i] = Math.min(coinNum[i], coinNum[i-coin]+1);
                }
            }
        }
        return coinNum[amount]==Integer.MAX_VALUE?-1:coinNum[amount];
    }
}
