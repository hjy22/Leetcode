package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
public class FinalPricesWithaSpecialDiscountinaShop1475E {
    public static void main(String[] args) {
        int[] prices = { 8, 4, 6, 2, 3 };
        int[] ans = finalPrices(prices);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[prices.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
}
