package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-minimums
public class SumofSubarrayMinimums907M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        //计算出该元素向左能辐射到的范围
        //左边比该元素小的数字
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        //计算出该元素向右能辐射到的范围
        //右边比该元素小的数字
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        //取模操作是必要的，以确保我们能处理大数据集
        long ans = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            long count = (long) (i - left[i]) * (right[i] - i) % mod;
            ans = (ans + arr[i] * count) % mod;
        }
        return (int) ans;
    }
}
