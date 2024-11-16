package Google;

// https://leetcode.com/problems/remove-element/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class RemoveElement27E {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums,val));
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0,fast=0;
        while (fast<nums.length) {
            //说明fast这么位置的不需要移除
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
