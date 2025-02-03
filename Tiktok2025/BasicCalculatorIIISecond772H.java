package Tiktok2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-iii/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class BasicCalculatorIIISecond772H {
    public static void main(String[] args) {
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> bracketStack = new Stack<>();
        Map<Integer, Integer> bracketMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                bracketStack.push(i);
            } else if (c == ')') {
                bracketMap.put(bracketStack.pop(), i);
            }
        }
        return cal(s, 0, s.length(), bracketMap);
    }

    public static int cal(String s, int left, int right, Map<Integer, Integer> bracketMap) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int rightBracket = bracketMap.get(i);
                num = cal(s, i + 1, rightBracket, bracketMap);
                i = rightBracket;
            }
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (!Character.isDigit(c) || i == right - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }

        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
