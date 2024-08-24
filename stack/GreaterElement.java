package Stack;

import java.util.Stack;

public class GreaterElement {
    // 输入一个数组 nums，请你返回一个等长的结果数组，结果数组中对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
    // 输入：[2,1,2,4,3]
    // 输出：[4,2,4,-1,-1]
    public static void main(String[] args) {
        int[] nums = { 2, 1, 2, 4, 3 };
        int[] ans = calculateGreaterElement(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] calculateGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty()&&nums[i]>=stack.peek()){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }
}
