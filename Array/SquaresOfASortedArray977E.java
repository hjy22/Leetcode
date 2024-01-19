package Array;

import java.util.Arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray977E {
    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        System.out.println(sortedSquares(nums));
    }

    // brute force
    // public static int[] sortedSquares(int[] nums) {
    // for(int i=0;i<nums.length;i++){
    // nums[i]=nums[i]*nums[i];
    // }
    // Arrays.sort(nums);
    // return nums;
    // }

    //two pointers
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length-1;
        while (left <= right) {
            if (Math.pow(nums[left], 2) < Math.pow(nums[right], 2)) {
                result[index] = (int) Math.pow(nums[right], 2);
                right--;
            } else {
                result[index] = (int) Math.pow(nums[left], 2);
                left++;
            }
            index--;
        }
        return result;
    }
}
