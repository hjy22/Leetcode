package String;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculatorII227M {
    public static void main(String[] args) {
        String s = "100000";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        s=s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (!Character.isDigit(c)||i==s.length()-1) {
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
                        stack.push(stack.pop()/ num);
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }

        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
