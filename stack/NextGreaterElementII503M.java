package Stack;

import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElementII503M {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 2, 4, 3 };
        int[] ans = calculateGreaterElement(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    //环形结构，使用模去存储数据
    public static int[] calculateGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*length - 1; i >= 0; i--) {
            while(!stack.isEmpty()&&nums[i%length]>=stack.peek()){
                stack.pop();
            }
            ans[i%length]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%length]);
        }
        return ans;
    }
}
