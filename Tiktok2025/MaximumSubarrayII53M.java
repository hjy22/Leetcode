package Tiktok2025;

// https://leetcode.com/problems/maximum-subarray/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MaximumSubarrayII53M {
    public static void main(String[] args) {
        int[] nums = { 5, 4, -1, 7, 8 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
