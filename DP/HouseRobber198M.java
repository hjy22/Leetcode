package DP;

public class HouseRobber198M {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 2 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        ans[0] = nums[0];
        ans[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i]);
            if (i >= 3) {
                ans[i] = Math.max(ans[i], ans[i - 3] + nums[i]);
            }

        }
        return ans[ans.length - 1];
    }
}
