package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/maximum-width-ramp/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MaximumWidthRamp962M {
    public static void main(String[] args) {
        int[] nums = { 6, 0, 8, 2, 1, 5 };
        System.out.println(maxWidthRamp(nums));
    }

    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxRamp = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxRamp = Math.max(maxRamp, j - i);
            }
        }
        return maxRamp;
    }

}
