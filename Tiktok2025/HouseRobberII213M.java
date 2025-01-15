package Tiktok2025;

// https://leetcode.com/problems/house-robber-ii/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class HouseRobberII213M {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 2 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        return Math.max(calRob(nums, 0, length - 1), calRob(nums, 1, length));
    }

    public static int calRob(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i < end; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;   
    }

}
