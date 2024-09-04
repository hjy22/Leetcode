package Labuladong.SliceWindows;

//https://leetcode.com/problems/subarray-product-less-than-k/
public class SubarrayProductLessThanK713M {
    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static long numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0, product = 1;
        while (right < nums.length) {
            int i = nums[right];
            product *= i;
            while (product >= k && left <= right) {
                int j = nums[left];
                product /= j;
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
