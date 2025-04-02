package Tiktok2025.Tiktok202504;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class LongestIncreasingSubsequence300M {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] maxLengthArr = new int[nums.length];
        Arrays.fill(maxLengthArr, 1);

        int maxLength = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxLengthArr[i] =Math.max(maxLengthArr[i], maxLengthArr[j]+1);
                }
                maxLength = Math.max(maxLength, maxLengthArr[i]);
            }
        }
        return maxLength;
    }
}
