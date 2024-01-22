package Array;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
public class MaximumProductDifferenceBetweenTwoPairs1913E {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 2, 7, 4 };
        System.out.println(maxProductDifference(nums));
    }

    public static int maxProductDifference(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length - 1] * nums[length - 2] - nums[0] * nums[1];
    }
}
