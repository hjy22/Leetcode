package Tiktok2025.SecondRound;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater42M {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        leftMax[0] = height[0];
        rightMax[length-1] = height[length - 1];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}
