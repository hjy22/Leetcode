package DP;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class NumberofLongestIncreasingSubsequence673 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int maxLen = 1;
        int ans=0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for(int i=0;i<nums.length;i++){
            for(int j =0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        for(int i=0;i<count.length;i++){
            if(dp[i]==maxLen){
                ans+=count[i];
            }
        }
        return ans;
    }
}
