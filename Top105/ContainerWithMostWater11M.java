package Top105;

// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
public class ContainerWithMostWater11M {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int low;
            boolean leftLower = false;
            if(height[left]<height[right]){
                low = height[left];
                leftLower =true;
            }else{
                low = height[right];
            }
            max = Math.max(max, low*(right-left));
            if(leftLower){
                left++;
            }else{
                right--;
            }

        }
        return max;
    }
}
