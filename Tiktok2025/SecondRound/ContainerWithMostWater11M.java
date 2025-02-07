package Tiktok2025.SecondRound;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater11M {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int thisArea = (right-left)*Math.min(height[left], height[right]);
            max = Math.max(max, thisArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
