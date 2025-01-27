package Tiktok2025;

import java.util.Stack;

public class NextGreaterElementII503M {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(nextGreaterElements(nums));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[i%n]>=stack.peek()){
                stack.pop();
            }
            ans[i%n]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return ans;
    }
}
