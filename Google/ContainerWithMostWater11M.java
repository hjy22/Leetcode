package Google;

// https://leetcode.com/problems/container-with-most-water/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class ContainerWithMostWater11M {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left =0,right=height.length-1;
        int maxArea = 0;
        while (left<right) {
            int low = height[left]<height[right]?height[left]:height[right];
            maxArea = Math.max(maxArea, low*(right-left));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
