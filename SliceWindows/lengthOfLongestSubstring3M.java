package SliceWindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class lengthOfLongestSubstring3M {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left <= right) {
            int lower = 0;
            Boolean leftLower=true;
            if (height[left] < height[right]) {
                lower = height[left];
            } else {
                lower = height[right];
                leftLower=false;
            }
            max = Math.max(max, lower*(right-left));
            if(leftLower){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
