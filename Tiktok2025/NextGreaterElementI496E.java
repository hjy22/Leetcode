package Tiktok2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElementI496E {
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        System.out.println(nextGreaterElement(nums1, nums2));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = calGreaterEle(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greater[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }

    public static int[] calGreaterEle(int[] num) {
        int[] greater = new int[num.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = num.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= num[i]) {
                stack.pop();
            }
            greater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num[i]);
        }
        return greater;
    }
}
