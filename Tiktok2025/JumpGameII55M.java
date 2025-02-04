package Tiktok2025;

// https://leetcode.com/problems/jump-game/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class JumpGameII55M {
    public static void main(String[] args) {
        int[] nums = { 2,3,1,1,4 };
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        for(int i=1;i<nums.length;i++){
            if(i<=maxIndex){
                maxIndex = Math.max(maxIndex,i+ nums[i]);
                System.out.println(maxIndex);
            }
        }
        return maxIndex>=nums.length-1;
    }
}
