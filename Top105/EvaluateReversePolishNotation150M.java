package Top105;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=study-plan-v2&envId=top-interview-150
public class EvaluateReversePolishNotation150M {
    public static void main(String[] args) {
        String[] token = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(token));

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if ("+-*/".contains(str)) {
                int a = stack.pop();
                int b = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
}
