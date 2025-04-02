package Tiktok2025.Tiktok202504;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class ValidParentheses20E {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                    continue;
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
