package Tiktok;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class LongestIncreasingSubsequence300M {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 1;
        dp[0]=1;
        Arrays.fill(dp, 1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength=Math.max(dp[i], maxLength);

        }
        return maxLength;
    }
}
