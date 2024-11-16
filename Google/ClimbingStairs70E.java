package Google;

// https://leetcode.com/problems/climbing-stairs/submissions/1454041200/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class ClimbingStairs70E {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
