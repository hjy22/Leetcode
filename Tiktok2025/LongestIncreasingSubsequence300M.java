package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class LongestIncreasingSubsequence300M {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.print(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] times = new int[nums.length];
        Arrays.fill(times, 1);
        int max = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    times[i]=Math.max(times[i], times[j]+1);
                }
            }
            max = Math.max(max, times[i]);
        }
        return max;
    }
}
