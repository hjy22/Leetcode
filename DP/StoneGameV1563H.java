package DP;

//https://leetcode.com/problems/stone-game-v/
public class StoneGameV1563H {
    public static void main(String[] args) {
        int[] stoneValue = { 6, 2, 3, 4, 5, 5 };
        System.out.println(stoneGameV(stoneValue));
    }

    public static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
        }

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = 0; 

                for (int k = i; k < j; k++) {
                    int leftSum = prefixSum[k + 1] - prefixSum[i];
                    int rightSum = prefixSum[j + 1] - prefixSum[k + 1];

                    if (leftSum < rightSum) {
                        dp[i][j] = Math.max(dp[i][j], leftSum + dp[i][k]);
                    } else if (leftSum > rightSum) {
                        dp[i][j] = Math.max(dp[i][j], rightSum + dp[k + 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], leftSum + Math.max(dp[i][k], dp[k + 1][j]));
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
