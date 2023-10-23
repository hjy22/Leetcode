package array;

//https://leetcode.com/problems/search-insert-position/
public class searchInsertPosition35E {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length-1;
        int pointer = 0;

        while(leftPointer<=rightPointer){
            pointer = leftPointer + (rightPointer-leftPointer)/2;
            if(nums[pointer]==target){
                return pointer;
            }else{
                if(nums[pointer]<target){
                    leftPointer = leftPointer+1;
                    pointer = (rightPointer+pointer)/2;
                }else if(nums[pointer]>target){
                    rightPointer = rightPointer-1;
                    pointer = (leftPointer+pointer)/2;
                }
            }
        }
        return leftPointer;
    }
}
