package DP;

//https://leetcode.com/problems/jump-game/
public class JumpGame55M {
    public static void main(String[] args) {
        int[] nums = { 0 };
        // int[] nums = { 1, 0, 1, 0 };
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int MAX_DISTANCE = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i <= MAX_DISTANCE) {
                MAX_DISTANCE = Math.max(MAX_DISTANCE, i + nums[i]);
            }
        }
        System.out.println(MAX_DISTANCE);
        return MAX_DISTANCE >= nums.length-1;
    }
}