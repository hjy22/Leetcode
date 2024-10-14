package Tiktok;

// https://leetcode.com/problems/climbing-stairs/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class ClimbingStairs70E {
    public static void main(String[] args) {
        int n=3;
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
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
