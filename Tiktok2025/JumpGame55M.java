package Tiktok2025;

// https://leetcode.com/problems/jump-game/
public class JumpGame55M {
    public static void main(String[] args) {
        int[] nums = {2,0,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int farthest=nums[0];
        for (int i=0;i<nums.length;i++) {
            if(i>farthest){
                return false;
            }
            farthest = Math.max(farthest, i+nums[i]);
        }
        System.out.println(farthest);
        return farthest>=nums.length-1;
    }
}
