package Tiktok2025;

// https://leetcode.com/problems/climbing-stairs/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class ClimbingStairs70E {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
