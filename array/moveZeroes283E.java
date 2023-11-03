package array;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes283E {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int item:nums){
            System.out.println(item);
        } 
    }

    public static void moveZeroes(int[] nums) {
        int lastIndex = 0;
        for(int item:nums){
            if(item!=0){
                nums[lastIndex++]=item;
            }
        }
        for(int i=lastIndex;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
