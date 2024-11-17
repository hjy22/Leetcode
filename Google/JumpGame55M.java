package Google;

// https://leetcode.com/problems/jump-game/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class JumpGame55M {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 4 };
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int farthest = nums[0];
        for(int i=0;i<nums.length;i++){
            if (i > farthest) {
                return false; 
            }
            farthest = Math.max(farthest, i+nums[i]);
        }
        return farthest>=nums[nums.length-1];
    }
}
