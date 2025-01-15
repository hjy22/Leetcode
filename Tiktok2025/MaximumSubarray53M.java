package Tiktok2025;

// https://leetcode.com/problems/maximum-subarray/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MaximumSubarray53M {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int[] maxArray = new int[nums.length];
        int max = nums[0];
        maxArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxArray[i] = Math.max(maxArray[i - 1] + nums[i], nums[i]);
            max = Math.max(max, maxArray[i]);
        }
        return max;
    }
}
