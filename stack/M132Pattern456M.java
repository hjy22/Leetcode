package Stack;

import java.util.Stack;

//https://leetcode.com/problems/132-pattern/
public class M132Pattern456M {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int kNum = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<kNum){
                return true;
            }
            //如果stack顶的一直比当前元素大，一直弹出
            while(!stack.isEmpty()&&nums[i]>stack.peek()){
                // 找到一个比当前元素大的a[j],knum
                kNum = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
