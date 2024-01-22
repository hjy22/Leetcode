package Array;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
public class MaximumProductofTwoElementsinanArray1464E {
    public static void main(String[] args) {
        int[] nums = { 3,4,5,2 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return (nums[length-1]-1)*(nums[length-2]-1);
    }
}
