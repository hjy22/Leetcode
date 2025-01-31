package Tiktok2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MinimumRemovetoMakeValidParentheses1249M {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> removeList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    removeList.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            removeList.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeList.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
