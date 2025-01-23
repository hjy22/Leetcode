package Tiktok2025;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater11M {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left] : height[right];
            max = Math.max(max, minHeight * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
