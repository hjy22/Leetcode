package Tiktok2025;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater42M {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return ans;
    }
}
