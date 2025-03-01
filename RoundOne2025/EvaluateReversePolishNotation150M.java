package RoundOne2025;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class EvaluateReversePolishNotation150M {
    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-/*".contains(token)) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                int value = 0;
                switch (token) {
                    case "+":
                        value = i1 + i2;
                        break;
                    case "-":
                        value = i1 - i2;
                        break;
                    case "*":
                        value = i1 * i2;
                        break;
                    case "/":
                        value = i1 / i2;
                        break;
                }
                stack.push(value);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
