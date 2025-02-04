package Tiktok2025;

// https://leetcode.com/problems/house-robber-ii/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class HouseRobberIIII213M {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 2 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        return Math.max(calRob(nums, 0, length - 1), calRob(nums, 1, length));
    }

    public static int calRob(int[] nums, int start, int end) {
        int length = end-start;
        if(length==1){
            return nums[start];
        }
        int[] dp = new int[length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[length-1];
    }
}
