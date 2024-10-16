package Tiktok;

// https://leetcode.com/problems/move-zeroes/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class MoveZeroes283E {
    public static void main(String[] args) {
        int[] nums = { 0,1,0,3,12};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");

        }
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0, quick = 0;
        while(quick<nums.length){
            if(nums[quick]!=0){
                nums[slow] = nums[quick];
                slow++;
            }
            quick++;
        }
        for(int i=slow;i<nums.length;i++){
            nums[i]=0;
        }
    }
}