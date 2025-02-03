package Tiktok2025;

// https://leetcode.com/problems/2-keys-keyboard/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class TwoKeysKeyboard650M {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(minSteps(n));
    }

    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
