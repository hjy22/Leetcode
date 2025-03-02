package RoundOne2025;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses20E {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
