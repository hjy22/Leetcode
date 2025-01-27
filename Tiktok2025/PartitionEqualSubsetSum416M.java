package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class PartitionEqualSubsetSum416M {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(canPartitionBT(nums));
        System.out.println(canPartitionDP(nums));
    }

    public static boolean canPartitionDP(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        boolean[][] dp = new boolean[nums.length+1][target+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j-nums[i-1]<0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static boolean canPartitionBT(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        return backTrack(nums, nums.length - 1, sum / 2);
    }

    public static boolean backTrack(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index < 0) {
            return false;
        }
        return backTrack(nums, index - 1, target) || backTrack(nums, index - 1, target - nums[index]);
    }
}
