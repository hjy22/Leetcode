package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/description/
//使用单调栈算法
public class NextGreater496E {
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        int[] ans = nextGreaterElement(nums1, nums2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //先存下下一个更大数字的数组
        int[] greater = calculateGreaterElement(nums2);
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();

        //根据nums2的值 存入map
        for(int i=0;i<greater.length;i++){
            map.put(nums2[i], greater[i]);
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=i==-1?-1:map.get(nums1[i]);
        }
        return ans;
    }

    public static int[] calculateGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }
}
