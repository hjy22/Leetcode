package Labuladong.List;

// https://leetcode.com/problems/remove-element/
public class RemoveElement27E {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0,quick=0;
        while (quick<nums.length) {
            if(nums[quick]!=val){
                nums[slow]=nums[quick];
                slow++;
            }
            quick++;
        }
        return slow;
    }
}
