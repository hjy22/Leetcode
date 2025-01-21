package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/number-of-visible-people-in-a-queue/submissions/1515361238/
public class NumberofVisiblePeopleiaQueue1944H {
    public static void main(String[] args) {
        int[] heights = { 10, 6, 8, 5, 11, 9 };
        int[] ans = canSeePersonsCount(heights);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
                count++;
            }
            ans[i] = stack.isEmpty() ? count : count + 1;
            stack.push(heights[i]);
        }
        return ans;
    }
}
