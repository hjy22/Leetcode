/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String addBinary(String a, String b) {
        int index1 = a.length() - 1, index2 = b.length() - 1;
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        String ans = "";
        while (index1 >= 0 && index2 >= 0) {
            int tmp1 = Integer.parseInt(a.charAt(index1));
            int tmp2 = Integer.parseInt(b.charAt(index2));
            int add = tmp1 + tmp2 + carry;
            if (add == 2) {
                stack.push(0);
                carry=1;
            } else {
                stack.push(1);
            }
        }

        while (!stack.isEmpty()) {
            ans+=stack.pop();
        }
        return ans;
    }
}
// @lc code=end
