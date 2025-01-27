package Tiktok2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorIII772H {
    public static void main(String[] args) {
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        s = s.replace(" ", "");
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> bracket = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                bracket.push(i);
            } else if (c == ')') {
                map.put(bracket.pop(), i);
            }
        }
        return cal(s, 0, s.length(), map);
    }

    public static int cal(String s, int left, int right, Map<Integer, Integer> map) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                num = cal(s, i+1, map.get(i), map);
                i = map.get(i);
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
