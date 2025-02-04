package Tiktok2025;

// https://leetcode.com/problems/arithmetic-slices/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class ArithmeticSlices413M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
