package Google;

import java.util.Stack;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class ShortestUnsortedContinuousSubarray581M {
    public static void main(String[] args) {
        int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = nums.length, right = 0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return (right-left+1>=0)?(right-left+1):0;
    }
    // public static int findUnsortedSubarray(int[] nums) {
    // int[] origin = Arrays.copyOf(nums, nums.length);
    // Arrays.sort(nums);
    // int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] != origin[i]) {
    // left = i;
    // break;
    // }
    // }

    // for (int i = nums.length - 1; i >= 0; i--) {
    // if (nums[i] != origin[i]) {
    // right = i;
    // break;
    // }
    // }

    // if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
    // return 0;
    // }

    // return right - left + 1;
    // }
}
